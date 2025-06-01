class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int firstMax=nums[n-1], max=nums[n-1], count=1;
        for(int i=n-2; i>=0; i--){
            if(nums[i] != nums[i+1]){
                max = nums[i];
                count++;

                if(count == 3) return max;
            }
        }
        return firstMax;
    }
}