class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<Integer> comb = new ArrayList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
        List<Integer> comb,
        Integer N,
        HashMap<Integer, Integer> counter,
        List<List<Integer>> results
    ) {
        if (comb.size() == N) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;

            comb.addLast(num);
            counter.put(num, count - 1);

            backtrack(comb, N, counter, results);

            comb.removeLast();
            counter.put(num, count);
        }
    }
}