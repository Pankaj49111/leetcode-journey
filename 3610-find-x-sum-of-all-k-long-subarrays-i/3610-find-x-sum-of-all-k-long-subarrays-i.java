class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Sort by value desc, key desc
            Queue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> {
                    if (a.getValue().equals(b.getValue()))
                        return b.getKey() - a.getKey();
                    return b.getValue() - a.getValue();
                });

            pq.addAll(freq.entrySet());

            // Sum top x most frequent
            int remaining = x;
            int sum = 0;
            while (remaining > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> e = pq.poll();
                sum += e.getKey() * e.getValue();
                remaining--;
            }

            ans[i] = sum;
        }

        return ans;
    }
}
