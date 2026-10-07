import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int minRemovalsLeft = 0;
        int minRemovalsRight = 0;

        // Step 1: Calculate the exact number of misplaced '(' and ')' to remove
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minRemovalsLeft++;
            } else if (c == ')') {
                if (minRemovalsLeft > 0) {
                    minRemovalsLeft--; // A valid match found
                } else {
                    minRemovalsRight++; // An unmatched closing bracket
                }
            }
        }

        Set<String> uniqueResults = new HashSet<>();
        dfs(s, 0, minRemovalsLeft, minRemovalsRight, 0, new StringBuilder(), uniqueResults);
        return new ArrayList<>(uniqueResults);
    }

    private void dfs(String s, int index, int leftRemovals, int rightRemovals, int openBalance, StringBuilder current, Set<String> result) {
        // Base case: If we reach the end of the string
        if (index == s.length()) {
            if (leftRemovals == 0 && rightRemovals == 0 && openBalance == 0) {
                result.add(current.toString());
            }
            return;
        }

        // Optimization/Pruning: If remaining deletions exceed available characters, or balance is negative
        if (leftRemovals < 0 || rightRemovals < 0 || openBalance < 0) {
            return;
        }

        char currentChar = s.charAt(index);
        int currentLength = current.length();

        if (currentChar == '(') {
            // Option 1: Remove the current '('
            dfs(s, index + 1, leftRemovals - 1, rightRemovals, openBalance, current, result);
            
            // Option 2: Keep the current '('
            current.append(currentChar);
            dfs(s, index + 1, leftRemovals, rightRemovals, openBalance + 1, current, result);
            current.setLength(currentLength); // Backtrack
            
        } else if (currentChar == ')') {
            // Option 1: Remove the current ')'
            dfs(s, index + 1, leftRemovals, rightRemovals - 1, openBalance, current, result);
            
            // Option 2: Keep the current ')'
            current.append(currentChar);
            dfs(s, index + 1, leftRemovals, rightRemovals, openBalance - 1, current, result);
            current.setLength(currentLength); // Backtrack
            
        } else {
            // If it is an alphabetical character, we must keep it
            current.append(currentChar);
            dfs(s, index + 1, leftRemovals, rightRemovals, openBalance, current, result);
            current.setLength(currentLength); // Backtrack
        }
    }
}
