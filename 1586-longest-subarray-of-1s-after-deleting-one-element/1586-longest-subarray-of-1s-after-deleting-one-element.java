class Solution {
    public int longestSubarray(int[] nums) {
        int dp1 = 0;  // streak of 1s with no deletion yet
        int dp0 = 0;  // streak of 1s after one deletion
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                dp1++;
                dp0++;
            } else {
                dp0 = dp1;  // simulate deletion of this 0
                dp1 = 0;
            }
            max = Math.max(max, dp0);
        }

        // Handle case when all are 1s → must delete one
        return max == nums.length ? max - 1 : max;
    }
}
