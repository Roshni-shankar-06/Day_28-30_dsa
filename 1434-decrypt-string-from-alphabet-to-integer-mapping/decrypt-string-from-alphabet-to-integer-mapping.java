class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; ) {
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));
                sb.append((char) ('a' + num - 1));
                i += 3;
         
