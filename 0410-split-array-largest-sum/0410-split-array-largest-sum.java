class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int p = j - 1; p < i; p++) {
                    int lastSum = prefixSum[i] - prefixSum[p];
                    int worst = Math.max(dp[p][j - 1], lastSum);
                    dp[i][j] = Math.min(dp[i][j], worst);
                }
            }
        }

        return dp[n][k];
    }

}