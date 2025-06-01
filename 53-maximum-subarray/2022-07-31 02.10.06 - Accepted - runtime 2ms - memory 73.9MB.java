class Solution {
    public int maxSubArray(int[] nums) {
        int t1=nums[0], t2=nums[0];
        int len = nums.length;
        for(int i=1; i<len; i++) {
            t2 = Math.max(nums[i], t2+nums[i]);
            t1 = Math.max(t1,t2);
        }
        return t1;
    }
}