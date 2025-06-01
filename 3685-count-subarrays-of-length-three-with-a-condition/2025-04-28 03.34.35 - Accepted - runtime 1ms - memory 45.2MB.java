class Solution {
    public int countSubarrays(int[] nums) {
        int count=0, n = nums.length;

        for(int i=0; i<n-2; i++){
            if(nums[i+1] == 2*(nums[i] + nums[i+2])) count++;
        }
        return count;
    }
}