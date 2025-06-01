class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int[] chars = new int[26];

        for(int i=0; i<sc.length; i++){
            chars[sc[i]-'a']++;
        }
        for(int i=0; i<tc.length; i++){
            chars[tc[i]-'a']--;
        }

        for(int i=0; i<26; i++){
            if(chars[i] != 0) return false;
        }
        return true;
    }
}