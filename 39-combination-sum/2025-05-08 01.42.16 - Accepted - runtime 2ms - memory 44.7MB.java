class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    void findCombination(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> ds) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            int num = arr[i];

            if (num <= target) {
                ds.add(arr[i]);
                findCombination(i, arr, target - num, res, ds);
                ds.remove(ds.size() - 1);  // backtrack
            } else {
                break;
            }
        }
    }
}
