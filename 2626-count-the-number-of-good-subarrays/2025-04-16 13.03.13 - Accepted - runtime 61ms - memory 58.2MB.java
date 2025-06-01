class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < n){
            if(map.containsKey(nums[j])) {
                k -= map.get(nums[j]);
            }
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(k <= 0){
                k += map.get(nums[i]) - 1;
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }

            ans += i;
            j++;
        }

        return ans;
    }
}