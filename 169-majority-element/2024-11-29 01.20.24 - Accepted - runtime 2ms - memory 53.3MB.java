class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = nums[0];

        for(int num : nums){
            if(count == 0){
                ele = num;
            }
            if(ele == num){
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}