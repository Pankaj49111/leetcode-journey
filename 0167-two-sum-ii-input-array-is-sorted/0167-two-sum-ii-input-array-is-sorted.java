class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0, j=nums.length-1;

        while(i<j){
            int total = nums[i]+nums[j];
            if(total == target) {
                return new int[]{i+1,j+1};
            }
            else if(total < target){
                i++;
            } else j--;
        }
        return new int[]{-1,-1};
    }
}