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
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            
            // Fill 'freq' number of elements with 'val'
            java.util.Arrays.fill(result, index, index + freq, val);
            index += freq;
        }
        
        return result;
    }
}

