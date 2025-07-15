class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(indMap.containsKey(target - nums[i])){
                return new int[]{indMap.get(target - nums[i]), i};
            } else {
                indMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}