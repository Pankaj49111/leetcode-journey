class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        if(n < 3) return false;

        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            pre[i] = Math.min(pre[i-1], nums[i]);
            // 1,2,
        }

        for(int i=n-2; i>=0; i--){
            suf[i] = Math.max(suf[i+1], nums[i]);
        }

        for(int i=0; i<n; i++){
            if(pre[i]<nums[i] && nums[i]<suf[i]) return true;
        }
        return false;
    }
}