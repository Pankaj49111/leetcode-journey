class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // skip duplicates at the same level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // pruning (no need to continue)

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
