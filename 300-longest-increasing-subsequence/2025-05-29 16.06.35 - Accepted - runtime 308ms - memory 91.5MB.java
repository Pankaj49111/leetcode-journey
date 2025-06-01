public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return helper(nums, -1, 0, dp);
    }

    private int helper(int[] nums, int prevIndex, int currIndex, int[][] dp) {
        if (currIndex == nums.length) {
            return 0;
        }
        if(dp[prevIndex+1][currIndex] != -1){
            return dp[prevIndex+1][currIndex];
        }

        int taken = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            taken = 1 + helper(nums, currIndex, currIndex + 1, dp);
        }

        int notTaken = helper(nums, prevIndex, currIndex + 1, dp);

        dp[prevIndex+1][currIndex] = Math.max(taken, notTaken);

        return dp[prevIndex+1][currIndex];
    }
}