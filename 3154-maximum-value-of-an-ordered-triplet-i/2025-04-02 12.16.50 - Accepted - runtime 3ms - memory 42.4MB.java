class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max=0;
        for(int i=0; i<n; i++){
            for(int j=n-1; j>i; j--){
                int k = i+1;
                while(k<j){
                    max = Math.max(max, (long)(nums[i] - nums[k])*nums[j]);
                    k++;
                }
            }
        }
        return Math.max(0, max);
    }
}