class Solution {
    public int minCapability(int[] nums, int k) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();

        int len = nums.length;

        while(min < max){
            int mid = (max+min)/2;
            int thefts = 0;
            for(int idx=0; idx<len; idx++){
                if(nums[idx] <= mid){
                    thefts++;
                    idx++;
                }
            }
            if(thefts >= k) max = mid;
            else min = mid+1;
        }
        return min;
    }
}