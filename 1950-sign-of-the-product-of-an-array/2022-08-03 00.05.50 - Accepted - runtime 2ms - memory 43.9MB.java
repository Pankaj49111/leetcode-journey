class Solution {
    
    public int signFunc(int product) {
        if(product > 0) return 1;
        else if(product < 0) return -1;
        else return 0;
    }
    
    public int arraySign(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                nums[i]=1;
            } else if(nums[i]<0) {
                nums[i]=-1;
            } else {
                nums[i]=0;
            }
        }
        int product=1;
        for(int i=0; i<nums.length; i++) {
            product *= nums[i];
        }
        
        return signFunc(product);
    }
}