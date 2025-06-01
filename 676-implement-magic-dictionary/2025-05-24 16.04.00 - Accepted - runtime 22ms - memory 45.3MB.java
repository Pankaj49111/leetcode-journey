class MagicDictionary {
    List<String> dict;

    public MagicDictionary() {
        dict = new ArrayList<>();
    }
    
    public void buildDict(String[] dicts) {
        dict.addAll(Arrays.asList(dicts));
    }
    
    public boolean search(String search) {
        for(String word: dict){
            if(word.length() != search.length()) continue;
            int diff = 0;
            for(int i=0; i<word.length(); i++){
                if(word.charAt(i) != search.charAt(i)){
                    diff++;
                    if(diff > 1) break;
                }
            }
            if(diff == 1) return true;
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