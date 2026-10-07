class WordDictionary {
    
    // Internal TrieNode class definition
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    private TrieNode root;

    /** Initializes the data structure object. */
  
   
