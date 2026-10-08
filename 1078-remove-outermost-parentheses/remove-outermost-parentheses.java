class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int opened = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If opened > 0, this '(' is NOT the outermost one
                if (opened > 0) {
                    ans.append(c);
                }
                opened++;
            } else {
                opened--;
                // If opened > 0 after decrementing, this ')' is NOT the outermost one
                if (opened > 0) {
                    ans.append(c);
                }
            }
        }
        
        return ans.toString();
    }
}
