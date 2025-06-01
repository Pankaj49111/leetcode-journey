class MagicDictionary {
    class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd = false;
    }
    Node root;

    public MagicDictionary() {
        root = new Node();
    }
    
    public void buildDict(String[] dict) {
        for(String d: dict){
            Node node = root;
            for(char c: d.toCharArray()){
                node.child.putIfAbsent(c, new Node());
                node = node.child.get(c);
            }
            node.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(root, searchWord.toCharArray(), 0, false);
    }

    boolean dfs(Node node, char[] word, int idx, boolean modified){
        if(idx == word.length) return (modified && node.isEnd);

        char curr = word[idx];
        for(char c: node.child.keySet()){
            Node currNode = node.child.get(c);
            if(c == curr){
                if(dfs(currNode, word, idx+1, modified)) return true;
            } else if(!modified){
                if(dfs(currNode, word, idx+1, true)) return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */