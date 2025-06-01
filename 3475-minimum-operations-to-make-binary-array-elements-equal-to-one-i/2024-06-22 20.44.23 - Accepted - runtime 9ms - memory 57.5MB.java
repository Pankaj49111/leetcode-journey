class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        int n = nums.length;
        for(int i = 0; i <= n-3; i++){
            if(nums[i] == 0){
                flip(nums, i);
                count++;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) return -1;
        }
        return count;
    }
    
    static void flip(int[] nums, int index){
        for(int i = 0; i < 3; i++) {
            if(nums[index+i] == 0){
                nums[index+i] = 1;
            } else {
                nums[index+i] = 0;
            }
        }
    }
}