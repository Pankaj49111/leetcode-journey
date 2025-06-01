class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] post = new int[len];
        pre[0] = nums[0];
        post[len-1] = nums[len-1];

        for(int i=1; i<len; i++){
            pre[i] = Math.min(nums[i],pre[i-1]);
        }

        for(int i=len-2; i>=0; i--){
            post[i] = Math.max(nums[i],post[i+1]);
        }

        for(int i=1; i<len; i++){
            if(pre[i] < nums[i] && nums[i] < post[i]){
                return true;
            }
        }
        return false;
    }
}