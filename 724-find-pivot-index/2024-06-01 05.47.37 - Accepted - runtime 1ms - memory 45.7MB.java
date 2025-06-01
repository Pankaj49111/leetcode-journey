class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        
        int[] prefixSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSums[i]; 
            int rightSum = prefixSums[n] - prefixSums[i + 1];            
            if (leftSum == rightSum) {
                return i;
            }
        }
        
        return -1;
    }
}