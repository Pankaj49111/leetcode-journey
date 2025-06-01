class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int n = nums.length;
        int start = 0;
        long sum = 0;
        for(int curr=0; curr<n; curr++){
            sum += nums[curr];
            while(sum * (curr - start + 1) >= k){
                sum -= nums[start];
                start++;
            }
            count += (curr - start + 1);
        }
        return count;
    }
}