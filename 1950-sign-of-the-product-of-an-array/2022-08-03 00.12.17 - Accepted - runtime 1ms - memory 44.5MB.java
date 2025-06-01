class Solution {
    public int arraySign(int[] nums) {
        int cntNeg=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                nums[i]=1;
            } else if(nums[i]<0) {
                nums[i]=-1;
                cntNeg++;
            } else {
                return 0;
            }
        }
        
        if((cntNeg & 1) == 0){
            return 1;
        } else {
            return -1;
        }
    }
}