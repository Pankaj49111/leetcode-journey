class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_NORMAL;
        double currMax = 0;

        for(int i=0; i<k; i++){
            currMax += nums[i];
        }
        System.out.println(currMax);
        max = currMax;
        for(int i=k; i<nums.length; i++){
            currMax += nums[i] - nums[i-k];
            max = Math.max(max, currMax);
        }

        return max/k;
    }
}