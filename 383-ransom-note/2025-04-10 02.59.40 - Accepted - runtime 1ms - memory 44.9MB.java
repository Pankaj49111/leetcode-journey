class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];

        for(char ch: ransomNote.toCharArray()){
            chars[ch-'a']++;
        }
        for(char ch: magazine.toCharArray()){
            chars[ch-'a']--;
        }

        for(int i=0; i<26; i++){
            if(chars[i] > 0) return false;
        }
        return true;
    }
}