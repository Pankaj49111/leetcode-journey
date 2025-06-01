class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        long curr = 0;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < n){
            if(map.containsKey(nums[j])) {
                curr += map.get(nums[j]);
            }
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(curr >= k){
                if(map.get(nums[i]) == 1) map.remove(nums[i]);
                else{
                    curr -= map.get(nums[i]) - 1;
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
                i++;
            }

            ans += (i);
            ++j;
        }

        return ans;
    }
}