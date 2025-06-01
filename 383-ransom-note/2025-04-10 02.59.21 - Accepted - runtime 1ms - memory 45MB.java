class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Map<Character, Integer> map = new HashMap<>();
        int[] chars = new int[26];

        for(char ch: ransomNote.toCharArray()){
            // map.put(ch, map.getOrDefault(ch,0)+1);
            chars[ch-'a']++;
        }
        for(char ch: magazine.toCharArray()){
            // if(map.containsKey(ch)){
            //     map.put(ch, map.getOrDefault(ch,0)-1);
            //     if(map.get(ch) == 0) map.remove(ch);
            // }
            chars[ch-'a']--;
        }

        for(int i=0; i<26; i++){
            if(chars[i] > 0) return false;
        }
        return true;
    }
}