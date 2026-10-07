import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int k, int remainingTarget, int start) {
        // Base Case 1: If the combination has the required number of elements
        if (currentList.size() == k) {
            // Check if the remaining target sum is fully satisfied
            if (remainingTarget == 0) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        // Optimization: Early termination if the remaining target becomes negative
        if (remainingTarget < 0) {
            return;
        }

        // Iterate through valid numbers from 'start' up to 9
        for (int i = start; i <= 9; i++) {
            // Include the current number
            currentList.add(i);
            
            // Recurse with the next number, reducing required count and target sum
            backtrack(result, currentList, k, remainingTarget - i, i + 1);
            
            // Backtrack: Remove the last added number to try other options
            currentList.remove(currentList.size() - 1);
        }
    }
}
