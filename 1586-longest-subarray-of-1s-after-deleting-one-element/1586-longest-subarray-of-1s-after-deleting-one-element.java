class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        int i=0, j=0, max=0, count=0;
        while(j<n){
            if(nums[j] == 0) count++;

            while(count>1){
                if(nums[i] == 0){
                    count--;
                }
                i++;
            }
            max = Math.max(max, j-i);
            j++;
        }
        return max;
    }
}