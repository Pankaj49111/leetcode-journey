class Solution {
    Map<String, List<String>> memo = new HashMap<>();
    String[] words;
    int[] groups;

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        this.words = words;
        this.groups = groups;
        return dfs(0, -1); // -1 means "no group yet"
    }

    List<String> dfs(int idx, int lastGroup){
        if(idx == words.length) return new ArrayList<>();

        String key = idx+""+lastGroup;
        if(memo.containsKey(key)) return memo.get(key);

        List<String> skip = dfs(idx+1, lastGroup);

        List<String> take = new ArrayList<>();
        if (lastGroup == -1 || groups[idx] != lastGroup) {
            take.add(words[idx]);
            take.addAll(dfs(idx + 1, groups[idx]));
        }
        
        List<String> best = take.size() > skip.size() ? take : skip;
        memo.put(key, best);
        return best;
    }
}