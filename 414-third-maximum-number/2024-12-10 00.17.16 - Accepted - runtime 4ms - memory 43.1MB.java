class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        
        int firstMax=nums[0], max=nums[0], count=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i]){
                max = nums[i];
                count++;

                if(count == 3) return max;
            }
        }
        return firstMax;
    }
}