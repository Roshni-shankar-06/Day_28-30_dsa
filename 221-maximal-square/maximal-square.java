class Solution {
  public int maximalSquare(char[][] matrix) {
    final int m = matrix.length;
    final int n = matrix[0].length;
    int[][] dp = new int[m][n];
   
