class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0, j=0, minLength=Integer.MAX_VALUE;
        int n=nums.length, sum=0;
        while(j<n){
            sum += nums[j];
            while(sum >= target){
                minLength = Math.min(minLength, j-i+1);

                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}