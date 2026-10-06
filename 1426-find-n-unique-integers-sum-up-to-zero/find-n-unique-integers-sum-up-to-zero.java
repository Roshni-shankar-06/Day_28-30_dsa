class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        
        // Fill the array using a symmetric pattern: i * 2 - n + 1
        for (int i = 0; i < n; i++) {
            ans[i] = i * 2 - n + 1;
        }
        
        return ans;
    }
}
