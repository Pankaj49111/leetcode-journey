class Solution {
    public int maxSubArray(int[] nums) {
        int m1 = nums[0], m2 = nums[0];
        for(int i=1; i<nums.length; i++){
            m1 = Math.max(m1+nums[i], nums[i]);
            m2 = Math.max(m1, m2);
        }
        return m2;
    }
}