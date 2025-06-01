class Solution {
    public void moveZeroes(int[] nums) {
        int countNZ = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, countNZ);
                countNZ++;
            }
        }
    }

    void swap(int[] nums, int index, int to){
        int temp = nums[index];
        nums[index] = nums[to];
        nums[to] = temp;
    }
}