class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        
        for(int i=0; i<s1.length(); i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }

        for(int i=0; i<s2.length() - s1.length(); i++){
            if(isMatching(c1, c2)) return true;

            c2[s2.charAt(i) - 'a']--;
            c2[s2.charAt(i + s1.length()) - 'a']++;
        }

        return isMatching(c1, c2);
    }

    public boolean isMatching(int[] c1, int[] c2){
        for(int i=0; i<26; i++){
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }
}