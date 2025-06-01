class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : ransomNote.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        for(char ch : magazine.toCharArray()) {
            if(map.containsKey(ch)){
                if(map.get(ch)>0){
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch)==0){
                        map.remove(ch);
                    }
                }
            }
        }
        return map.size()==0?true:false;
    }
}