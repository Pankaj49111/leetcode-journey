class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, maxLen=0;

        for(int j=0; j<s.length(); j++){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}