class MagicDictionary {
    class Node{
        Map<Character, Node> child = new HashMap<>();
        boolean isEnd = false;
    }
    Node root;
    public MagicDictionary() {
        root = new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for(String dict: dictionary){
            Node node = root;
            for(char ch: dict.toCharArray()){
                node.child.putIfAbsent(ch, new Node());
                node = node.child.get(ch);
            }
            node.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(searchWord.toCharArray(), root, 0, false);
    }

    boolean dfs(char[] word, Node node, int idx, boolean isModified){
        if(idx == word.length) return (isModified && node.isEnd);

        char curr = word[idx];
        for(char c: node.child.keySet()){
            Node cNode = node.child.get(c);
            if(c == curr){
                if(dfs(word, cNode, idx+1, isModified)) return true;
            } else if(!isModified) {
                if(dfs(word, cNode, idx+1, true)) return true;
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