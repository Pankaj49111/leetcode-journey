class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, length=0;
        Set<Character> set = new HashSet<>();

        for(int j=0; j<s.length(); j++){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                length = Math.max(length, j-i+1);
            } else {
                while(s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
                set.add(s.charAt(j));
            }
        }
        return length;
    }
}