class Solution {
    public int[] getNoZeroIntegers(int n) {
        // Iterate through all possible values for the first integer 'a'
        for (int a = 1; a < n; a++) {
            int b = n - a;
            
            // Check if both 'a' and 'b' contain no zero digits
            if (!hasZero(a) && !hasZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{-1, -1}; // Fallback (guaranteed by constraints not to be reached)
    }

    // Helper method to check if a number contains the digit 0
    private boolean hasZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}
