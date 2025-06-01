class WordFilter {
    class Node{
        Map<Character, Node> child = new HashMap<>();
        int index = -1;
    }
    Node root;

    public WordFilter(String[] words) {
        root = new Node();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int len = word.length();

            for(int j=0; j<=len; j++){
                String subSuff = word.substring(j);
                String key = subSuff + "#" + word;
                insert(key, i);
            }
        }
    }

    void insert(String word, int idx){
        Node node = root;
        for(char c: word.toCharArray()){
            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
            node.index = idx;
        }
    }
    
    public int f(String pref, String suff) {
        String key = suff + "#" + pref;
        Node node = root;
        for(char c: key.toCharArray()){
            if(!node.child.containsKey(c)){
                return -1;
            } 
            node = node.child.get(c);
        }
        return node.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */