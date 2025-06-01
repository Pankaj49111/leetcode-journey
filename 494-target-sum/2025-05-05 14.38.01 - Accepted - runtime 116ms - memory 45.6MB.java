class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target);
    }

    int calculate(int[] nums, int idx, int sum, int target){
        String key = idx+"-"+sum;
        if(memo.containsKey(key)) return memo.get(key);

        if(idx == nums.length){
            return sum == target ? 1 : 0;
        }

        int add = calculate(nums, idx+1, sum+nums[idx], target);
        int sub = calculate(nums, idx+1, sum-nums[idx], target);

        memo.put(key, (add+sub));
        return memo.get(key);
    }
}