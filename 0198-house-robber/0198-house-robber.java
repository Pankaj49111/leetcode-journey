class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n + 2]; // +2 to avoid out-of-bound for dp[i+2]
        
        for (int i = n - 1; i >= 0; i--) {
            int take = nums[i] + dp[i + 2];
            int skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }
        
        return dp[0];
    }
}
