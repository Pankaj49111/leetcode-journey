class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, new ArrayList<>(), res, n, k);
        return res;
    }

    void backtrack(int idx, List<Integer> combination, List<List<Integer>> res, int n, int k) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i <= n; i++) {
            combination.add(i);
            backtrack(i + 1, combination, res, n, k);
            combination.removeLast();
        }
    } 
}