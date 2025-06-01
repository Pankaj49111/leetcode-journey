class Solution {
    public int coinChange(int[] coins, int amt) {
        int[] dp = new int[amt+1];
        Arrays.fill(dp, amt+1);
        dp[0] = 0;

        for(int i=1; i<=amt; i++){
            for(int coin: coins){
                if(i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amt] > amt ? -1 : dp[amt];
    }
}