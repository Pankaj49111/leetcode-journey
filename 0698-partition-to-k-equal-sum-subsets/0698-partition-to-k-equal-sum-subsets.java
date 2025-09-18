class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int total = 0;
        for (int v : nums) total += v;
        if (total % k != 0) return false;
        int target = total / k;

        Arrays.sort(nums);
        if (nums[n - 1] > target) return false;

        int[] buckets = new int[k];
        return backtrack(nums, n-1, buckets, target);
    }

    boolean backtrack(int[] nums, int idx, int[] buckets, int target) {
        if (idx < 0) return true;

        int val = nums[idx];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + val <= target) {
                buckets[i] += val;
                if (backtrack(nums, idx - 1, buckets, target)) return true;
                buckets[i] -= val;
            }
            // symmetry pruning: if this bucket is empty and placing here didn't work,
            // there's no need to try other empty buckets.
            if (buckets[i] == 0) break;
        }
        return false;
    }
}
