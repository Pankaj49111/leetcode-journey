class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int i=0, j=0, max=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            while(seen.contains(ch)){
                char ct = s.charAt(i);
                seen.remove(ct);
                i++;
            }
            seen.add(ch);
            j++;
            max = Math.max(max, seen.size());
        }
        return max;
    }
}