class Solution {
    public int minOperations(int[] nums) {
        int cnt=0, n=nums.length;
        for(int i=0; i<=n-3; i++){
            if(nums[i] == 0){
                flip(nums, i);
                cnt++;
            }
            System.out.println();
        }
        for(int num:nums){
            if(num == 0) return -1;
        }
        return cnt;
    }

    void flip(int[] nums, int idx){
        for(int i=0; i<3; i++){
            nums[idx+i] = nums[idx+i]^1;
        }
    }
}