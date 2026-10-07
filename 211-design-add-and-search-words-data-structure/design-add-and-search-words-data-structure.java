class WordDictionary {
    
    // Internal TrieNode class definition
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    private TrieNode root;

    /** Initializes the data structure object. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }
    
    /** Returns true if there is any string in the data structure that matches word. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    // Helper function to handle exact matching and '.' wildcards via backtracking
    private boolean dfs(String word, int index, TrieNode curr) {
        if (curr == null) return false;
        
        // Base case: If we reached the end of the word, check if it marks a valid word
        if (index == word.length()) {
            return curr.isWord;
        }
        
        char c = word.charAt(index);
        
        // If it's a wildcard, we must explore all 26 possible branches
        if (c == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        
