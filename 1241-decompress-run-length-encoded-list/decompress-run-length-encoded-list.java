class Solution {
    public int[] decompressRLElist(int[] nums) {
        // First pass: find the total length of the output array
        int totalLength = 0;
        for (int i = 0; i < nums.length; i += 2) {
            totalLength += nums[i];
        }
        
        // Allocate the result array
        int[] result = new int[totalLength];
        int index = 0;
        
        // Second pass: fill the result array based on frequency and value
