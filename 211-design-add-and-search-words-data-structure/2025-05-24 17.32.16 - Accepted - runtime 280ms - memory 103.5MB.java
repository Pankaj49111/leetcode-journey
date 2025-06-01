class WordDictionary {
    class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd = false;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char c: word.toCharArray()){
            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word.toCharArray(), 0);
    }

    boolean dfs(Node node, char[] word, int idx){
        if(idx == word.length){
            return node.isEnd;
        }

        char c = word[idx];
        if(c == '.'){
            for(Node next: node.child.values()){
                if(dfs(next, word, idx+1)) return true;
            }
            return false;
        } else {
            Node next = node.child.get(c);
            if(next == null) return false;

            return dfs(next, word, idx+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */