class Solution {
    public int fib(int n) {
        if(n<=1) return n;

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }

    int fib(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n] != -1) return dp[n];
        if(dp[n-1] == -1) {
            dp[n-1] = fib(n-1, dp);
        }
        if(dp[n-2] == -1) {
            dp[n-2] = fib(n-2, dp);
        }

        dp[n] = dp[n-1] + dp[n-2];
        return dp[n];
    }
}