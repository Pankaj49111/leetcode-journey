class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0, count = 0;

        for(int num: nums){
            preSum += num;

            count += map.getOrDefault(preSum-k, 0);

            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}