import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        
        // 1. Sort: Width ascending, Height descending for equal widths
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending height
            } else {
                return a[0] - b[0]; // Ascending width
            }
        });
        
        // 2. Find the Longest Increasing Subsequence (LIS) on heights
        int[] dp = new int[envelopes.length];
        int len = 0;
        
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            
            // Binary search to find the insertion index
            int index = Arrays.binarySearch(dp, 0, len, height);
            
            // If height is not found, binarySearch returns -(insertion point) - 1
         
