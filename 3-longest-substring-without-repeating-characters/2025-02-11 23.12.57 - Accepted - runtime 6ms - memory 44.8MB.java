class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int i=0, j=0, length=0;
        while(j<len){
            if(set.add(s.charAt(j))){
                j++;
                length = Math.max(length, j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return length;
    }
}