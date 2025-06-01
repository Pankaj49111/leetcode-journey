class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Max subarray (standard Kadane)
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // Min subarray (to calculate wraparound)
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);
        }

        // If all elements are negative, maxSum is correct (don't wrap)
        if (maxSum < 0) return maxSum;

        // Otherwise, take the max of (normal max) and (wraparound max)
        return Math.max(maxSum, totalSum - minSum);
    }
}