class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    final int m = matrix.length;
    final int n = matrix[0].length;
    int ans = Integer.MIN_VALUE;

    for (int baseCol = 0; baseCol < n; ++baseCol) {
      // sums[i] := sum(matrix[i][baseCol..j])
     
