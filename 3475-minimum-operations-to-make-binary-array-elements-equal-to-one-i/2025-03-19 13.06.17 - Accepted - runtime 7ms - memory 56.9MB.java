class Solution {
    public int minOperations(int[] nums) {
        int cnt=0, n=nums.length;
        for(int i=0; i<=n-3; i++){
            if(nums[i] == 0){
                cnt++;
                nums[i] = nums[i] ^ 1;
                nums[i + 1] = nums[i + 1] ^ 1;
                nums[i + 2] = nums[i + 2] ^ 1;
            }
        }
        for(int num:nums){
            if(num == 0) return -1;
        }
        return cnt;
    }
}