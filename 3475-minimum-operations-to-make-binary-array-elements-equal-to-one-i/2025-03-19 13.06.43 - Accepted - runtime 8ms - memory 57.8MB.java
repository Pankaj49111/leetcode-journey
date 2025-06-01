class Solution {
    public int minOperations(int[] nums) {
        int cnt=0, n=nums.length;
        for(int i=0; i<=n-3; i++){
            if(nums[i] == 0){
                cnt++;
                for(int k=0; k<3; k++){
                    nums[i+k] = nums[i+k]^1;
                }
            }
        }
        for(int num:nums){
            if(num == 0) return -1;
        }
        return cnt;
    }
}