class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        
        for(char ch : word1.toCharArray()){
            ch1[ch-'a']++;
        }
        for(char ch : word2.toCharArray()){
            ch2[ch-'a']++;
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