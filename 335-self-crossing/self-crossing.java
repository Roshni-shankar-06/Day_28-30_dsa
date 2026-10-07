class Solution {
    public boolean isSelfCrossing(int[] distance) {
        if (distance.length <= 3) return false;
        
        for (int i = 3; i < distance.length; ++i) {
            // Case 1: Current line crosses the 3rd line before it
            if (distance[i - 2] <= distance[i] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            // Case 2: Current line meets the 4th line before it
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i - 2] <= distance[i] + distance[i - 4]) {
                return true;
            }
            // Case 3: Current line crosses the 5th line before it
            if (i >= 5 && distance[i - 4] <= distance[i - 2] && distance[i - 2] <= distance[i] + distance[i - 4] 
                && distance[i - 1] <= distance[i - 3] && distance[i - 3] <= distance[i - 1] + distance[i - 5]) {
                return true;
            }
        }
        
        return false;
    }
}
