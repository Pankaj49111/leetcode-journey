class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;

        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] < k) {
                
                String[] parts = s.split(String.valueOf(ch));

                int maxLen = 0;

                for(String part: parts){
                    maxLen = Math.max(maxLen, longestSubstring(part, k));
                }
                return maxLen;
            }
        }
        return s.length();
    }
}