class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        char[] ch1 = new char[26];
        char[] ch2 = new char[26];
        
        for(int i=0; i<word1.length(); i++){
            ch1[word1.charAt(i)-'a']++;
            ch2[word2.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++) {
            if((ch1[i] == 0 && ch2[i] != 0) || (ch1[i] != 0 && ch2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
}