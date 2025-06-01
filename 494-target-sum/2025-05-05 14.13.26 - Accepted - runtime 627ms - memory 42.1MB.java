class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target);
    }

    int calculate(int[] nums, int idx, int sum, int target){
        if(idx == nums.length){
            return sum == target ? 1 : 0;
        }

        int add = calculate(nums, idx+1, sum+nums[idx], target);
        int sub = calculate(nums, idx+1, sum-nums[idx], target);

        return add+sub;
    }
}