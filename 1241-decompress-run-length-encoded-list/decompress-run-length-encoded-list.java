class Solution {
    public int[] decompressRLElist(int[] nums) {
        // First pass: find the total length of the output array
        int totalLength = 0;
        for (int i = 0; i < nums.length; i += 2) {
   
