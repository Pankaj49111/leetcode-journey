class Solution {
    public int maximumCount(int[] nums) {
        int pos = nums.length - binary(nums, true);
        int neg = binary(nums, false);
        return Math.max(pos, neg);
    }

    int binary(int[] nums, boolean isPos) {
        int l=0, h=nums.length -1;

        while(l<=h){
            int mid = l + (h-l)/2;

            if(isPos){
                if(nums[mid] > 0){
                    h = mid-1; 
                } else {
                    l = mid+1;
                }
            } else {
                if(nums[mid] < 0){
                    l = mid+1;
                } else {
                    h= mid-1;
                }
            }
        }
        return isPos ? l : h+1;
    }
}