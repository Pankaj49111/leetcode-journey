class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0, n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num: nums){
            for(int j=target; j>= num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
            if(dp[target]) return true;
        }
        return dp[target];
    }
}