public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int pos, int[] memo) {
        if (pos >= nums.length - 1) return 0;

        if(memo[pos] != -1) return memo[pos];

        int steps = nums[pos];
        int minJumps = Integer.MAX_VALUE;

        for (int j = 1; j <= steps; j++) {
            int next = dfs(nums, pos + j, memo);
            if (next != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + next);
            }
        }

        memo[pos] = minJumps;
        return memo[pos];
    }
}