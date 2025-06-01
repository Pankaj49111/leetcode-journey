class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target+1];
        return countWays(nums, target, memo);
    }

    int countWays(int[] nums, int target, Integer[] memo){
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(memo[target] != null) return memo[target];

        int totalWays = 0;
        for(int num: nums){
            totalWays += countWays(nums, target - num, memo);
        }
        memo[target] = totalWays;
        return totalWays;
    }
}