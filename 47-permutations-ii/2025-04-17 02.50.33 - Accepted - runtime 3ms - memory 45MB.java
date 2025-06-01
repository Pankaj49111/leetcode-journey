class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> comb = new ArrayList<>();
        this.backtrack(comb, nums.length, freqMap, results);
        return results;
    }

    void backtrack(List<Integer> comb, Integer N, 
                    HashMap<Integer, Integer> freqMap, List<List<Integer>> results) {
        if (comb.size() == N) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;

            comb.add(num);
            freqMap.put(num, count - 1);

            backtrack(comb, N, freqMap, results);

            comb.removeLast();
            freqMap.put(num, count);
        }
    }
}