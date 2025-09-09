class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {

        /**
        formula: [j+delay, j+forget−1]
        transformed to: [i−forget+1 <= j <= i−delay]
         */
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;  // Day 1, one person knows the secret

        long sharing = 0; // running window of who can share

        for (int day = 2; day <= n; day++) {
            // People start sharing after delay
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            // People stop sharing after forget
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = sharing;
        }

        // Sum all who still remember on day n
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}
