class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, freq.get(num));

            if (!first.containsKey(num)) {
                first.put(num, i);
            }
            last.put(num, i);
        }

        int minLength = nums.length;
        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                int len = last.get(num) - first.get(num) + 1;
                minLength = Math.min(minLength, len);
            }
        }

        return minLength;
    }
}
