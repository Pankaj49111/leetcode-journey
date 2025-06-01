class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

    int rob(int[] nums, int start, int end){
        int n = end-start+1;

        if(n == 0) return 0;
        if(n == 1) return nums[start];
        
        int[] dp = new int[n];
        
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i=start+2; i<=end; i++){
            dp[i-start] = Math.max(dp[i-start-1], dp[i-start-2]+nums[i]);
        }
        return dp[n-1];
    }
}