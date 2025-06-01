class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] response = new int[n];
        response[0] = nums[0];
        for(int i=1; i<n; i++){
            response[i] = response[i-1]+nums[i];
        }
        return response;
    }
}