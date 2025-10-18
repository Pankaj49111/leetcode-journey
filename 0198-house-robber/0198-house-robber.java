class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int i, Integer[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != null) return memo[i];

        // option1: rob current, skip next
        int take = nums[i] + dfs(nums, i + 2, memo);
        // option2: skip current
        int skip = dfs(nums, i + 1, memo);

        memo[i] = Math.max(take, skip);
        return memo[i];
    }
}
