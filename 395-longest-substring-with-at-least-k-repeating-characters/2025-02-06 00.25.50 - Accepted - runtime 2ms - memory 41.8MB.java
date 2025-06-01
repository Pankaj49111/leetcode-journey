class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if(s == null || len == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        boolean flag = true;
        for(char ch: map.keySet()){
            if(map.get(ch) < k) {
                flag = false;
                break;
            }
        }

        if(flag) return len;

        int maxLen = 0, start = 0;
        for(int i=0; i< len; i++){
            char ch = s.charAt(i);
            if(map.get(ch) < k){
                maxLen = Math.max(maxLen, longestSubstring(s.substring(start, i), k));
                start = i+1;
            }
        }
        maxLen = Math.max(maxLen, longestSubstring(s.substring(start), k));
        return maxLen;
    }
}