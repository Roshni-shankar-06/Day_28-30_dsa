import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1: left is palindrome, and reverse of right exists in map
                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(revRight) && map.get(revRight) != i) {
                        result.add(Arrays.asList(map.get(revRight), i));
                    }
                }

                // Case 2: right is palindrome, and reverse of left exists in map
                // (j != word.length() prevents duplicate checking for j == word.length())
                if (j != word.length() && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        result.add(Arrays.asList(i, map.get(revLeft)));
                    }
           
