class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Scenario 1: Rob from the first house to the second-to-last house (exclude last house)
        int max1 = robHelper(nums, 0, nums.length - 2);
        // Scenario 2: Rob from the second house to the last house (exclude first house)
        int max2 = robHelper(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int prev2 = 0; // Represents dp[i-2]
        int prev1 = 0; // Represents dp[i-1]
        
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
         
}
