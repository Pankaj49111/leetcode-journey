class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int len = s.length();
        int i=0, j=0, maxLength=0;
        while(j<len){
            if(seen.add(s.charAt(j))){
                j++;
                maxLength = Math.max(maxLength, j-i);
            } else {
                seen.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}