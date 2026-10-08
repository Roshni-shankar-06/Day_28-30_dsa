class Solution {
  public int maximalSquare(char[][] matrix) {
    final int m = matrix.length;
    final int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int maxLength = 0;

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j) {
       
