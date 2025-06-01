class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int left = 0, res = 0;

        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        int distEle = set.size();
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() == distEle) {
                res += nums.length - i;
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
        }
        return res;
    }
}