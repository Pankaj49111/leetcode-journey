class Solution {
    public int[] twoSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int len = nums.length;
        for(int i=0; i<len; i++) {
            if(map.containsKey(k-nums[i])) {
                result[1] = i;
                result[0] = map.get(k - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}