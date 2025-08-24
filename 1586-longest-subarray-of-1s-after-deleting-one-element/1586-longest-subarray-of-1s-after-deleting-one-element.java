class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2]; // dp[i][0] = no deletion, dp[i][1] = one deletion
        int max = 0;

        if (nums[0] == 1) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 0; // no-deletion can't continue
                dp[i][1] = dp[i - 1][0]; // delete this 0
            }
            max = Math.max(max, dp[i][1]);
        }

        if (max == 0 && Arrays.stream(nums).anyMatch(num -> num == 1)) {
            return n - 1;
        }

        return max;
    }

}