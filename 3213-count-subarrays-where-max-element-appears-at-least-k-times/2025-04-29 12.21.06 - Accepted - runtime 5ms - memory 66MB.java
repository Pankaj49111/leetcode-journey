class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(num, max);
        }

        long count = 0;
        long total = 0;
        int n = nums.length;
        int i=0;
        for(int j=0; j<n; j++){
            if(nums[j] == max){
                count++;
            }
            while(count >= k){
                total += n - j;
                
                if(nums[i] == max){
                    count--;
                }
                i++;
            }
        }
        return total;
    }
}