class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        for(char ch : ransomNote.toCharArray()) {
            int newCount = map.getOrDefault(ch,0)-1;
            if (newCount<0)
                return false;
            map.put(ch, newCount);
        }
        return true;
    }
}