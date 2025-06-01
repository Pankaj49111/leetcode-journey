class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0;
        long max = 0, sum = 0;
        Set<Integer> set = new HashSet<>();

        while (j < nums.length) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            if (set.size() == k) {
                max = Math.max(max, sum);
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return max;
    }
}