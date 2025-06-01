class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int lSum=0, total=0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }

        for(int i=0; i<n; i++){
            if(lSum*2 == total - nums[i]){
                return i;
            }
            lSum += nums[i];
        }
        return -1;
    }
}