class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return countWays(nums, target, memo);
    }

    int countWays(int[] nums, int target, Map<Integer, Integer> memo){
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(memo.containsKey(target)) return memo.get(target);

        int totalWays = 0;
        for(int num: nums){
            totalWays += countWays(nums, target - num, memo);
        }
        memo.put(target, totalWays);
        return totalWays;
    }
}