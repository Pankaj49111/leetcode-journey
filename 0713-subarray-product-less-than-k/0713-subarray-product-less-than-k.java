class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0, prd=1, cnt=0;
        for(int j=0; j<nums.length; j++){
            prd *= nums[j];

            while(prd >= k && i <= j){
                prd /= nums[i++];
            }

            cnt += j-i+1;
        }
        return cnt;
    }
}