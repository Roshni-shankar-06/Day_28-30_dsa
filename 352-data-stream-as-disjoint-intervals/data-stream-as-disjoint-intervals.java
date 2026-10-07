import java.util.TreeMap;
import java.util.Map;

class SummaryRanges {
    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) return;
        
        Integer low = map.lowerKey(val);
        Integer high = map.higherKey(val);
        
        boolean mergeLow = low != null && map.get(low)[1] + 1 >= val;
        boolean mergeHigh = high != null && high - 1 == val;
        
        if (mergeLow && mergeHigh) {
            map.get(low)[1] = map.get(high)[1];
            map.remove(high);
        } else if (mergeLow) {
            map.get(low)[1] = Math.max(map.get(low)[1], val);
        } else if (mergeHigh) {
            int[] highInterval = map.get(high);
            map.remove(high);
            map.put(val, new int[]{val, highInterval[1]});
        } else {
            map.put(val, new int[]{val, val});
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int[] interval : map.values()) {
            res[i++] = interval;
        }
        return res;
    }
}
