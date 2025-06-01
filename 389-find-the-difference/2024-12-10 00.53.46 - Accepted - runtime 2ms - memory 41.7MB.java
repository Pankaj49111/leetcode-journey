class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];

        for(char tc : t.toCharArray()){
            chars[tc-'a']++;
        }
        for(char sc : s.toCharArray()){
            chars[sc-'a']--;
        }

        for(int i=0; i<26; i++){
            if(chars[i]!=0) return (char)(i+'a');
        }
        return ' ';
    }
}