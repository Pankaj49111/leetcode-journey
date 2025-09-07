class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    void dfs(int[] cands, int target, List<Integer> sub, int idx){
        if(target == 0){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(target < 0) return;

        for(int i=idx; i<cands.length; i++){
            sub.add(cands[i]);
            dfs(cands, target-cands[i], sub, i);
            sub.remove(sub.size()-1);
        }
    }
}