class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If the target is out of possible range, return 0
        if (Math.abs(target) > sum) return 0;

        int offset = sum; // To handle negative indices
        int[][] dp = new int[nums.length + 1][2 * sum + 1];

        // Base case: one way to sum up to 0 with 0 elements
        dp[0][offset] = 1;

        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + offset] != 0) {
                    dp[i][j + num + offset] += dp[i - 1][j + offset]; // add num
                    dp[i][j - num + offset] += dp[i - 1][j + offset]; // subtract num
                }
            }
        }

        return dp[nums.length][target + offset];
    }
}