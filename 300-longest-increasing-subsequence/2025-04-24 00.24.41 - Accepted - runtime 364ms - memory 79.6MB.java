class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lisHelper(nums, 0, -1, memo);
    }

    private int lisHelper(int[] nums, int curr, int prevIdx, int[][] memo) {
        if (curr == nums.length) return 0;

        if (memo[curr][prevIdx + 1] != -1) return memo[curr][prevIdx + 1];

        int take = 0;
        if (prevIdx == -1 || nums[curr] > nums[prevIdx]) {
            take = 1 + lisHelper(nums, curr + 1, curr, memo);
        }

        int skip = lisHelper(nums, curr + 1, prevIdx, memo);

        return memo[curr][prevIdx + 1] = Math.max(take, skip);
    }
}
