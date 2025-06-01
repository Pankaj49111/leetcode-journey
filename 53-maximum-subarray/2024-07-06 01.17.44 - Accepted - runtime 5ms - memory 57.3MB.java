class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];

        pre[0] = nums[0];
        for(int i = 1; i < n; i++) {
            pre[i] = Math.max(nums[i], nums[i]+pre[i-1]);
        }

        return Arrays.stream(pre).max().orElse(0);
    }
}