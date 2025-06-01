class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return stairs(n, dp);
    }

    int stairs(int n, int[] dp){
        if(n<=2) return n;

        if(dp[n] != -1) return dp[n];

        if(dp[n-1] == -1) dp[n-1] = stairs(n-1, dp);

        if(dp[n-2] == -1) dp[n-2] = stairs(n-2, dp);

        dp[n] = dp[n-1] + dp[n-2];
        return dp[n];
    }
}