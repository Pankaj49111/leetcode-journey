class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return canBreak(s, wordDict, 0);
    }
    boolean canBreak(String s, List<String> dict, int start){
        if(start == s.length()) return true;
        if(memo.containsKey(start)) return memo.get(start);

        for(int end = start+1; end<= s.length(); end++){
            String sub = s.substring(start, end);
            if(dict.contains(sub) && canBreak(s, dict, end)) {
                memo.put(start, true);
                return true;
            }
        }
        memo.put(start, false);
        return false;
    }
}