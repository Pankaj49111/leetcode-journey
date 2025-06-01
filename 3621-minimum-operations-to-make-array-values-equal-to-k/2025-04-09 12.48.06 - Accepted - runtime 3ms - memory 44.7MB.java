class Solution {
    public int minOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(num < k) return -1;
            if(num > k) map.put(num, map.getOrDefault(num,0)+1);
        }
        return map.size();
    }
}