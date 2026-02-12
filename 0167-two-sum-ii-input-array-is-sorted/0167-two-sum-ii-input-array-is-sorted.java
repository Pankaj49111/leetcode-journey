class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length, j=n-1;

        for(int i=0; i<j; ){
            int total = nums[i]+nums[j];
            if(total == target){
                return new int[]{i+1, j+1};
            } else if(total < target) i++;
            else j--;
        }
        return new int[]{-1};
    }
}