class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = 0;       // dp[i-2]
        int prev1 = 0;       // dp[i-1]
        int curr = 0;

        for (int x : nums) {
            curr = Math.max(prev1, prev2 + x);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
