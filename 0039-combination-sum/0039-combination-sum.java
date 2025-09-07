class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    void backtrack(int[] candidates, int target, List<Integer> comb, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;

            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], comb, i);
            comb.remove(comb.size() - 1); // Backtrack
        }
    }
}
