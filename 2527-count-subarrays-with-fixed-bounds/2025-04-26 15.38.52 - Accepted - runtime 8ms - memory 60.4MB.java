class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastMinK = -1, lastMaxK = -1, invalidIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) invalidIdx = i;

            if (nums[i] == minK) lastMinK = i;
            if (nums[i] == maxK) lastMaxK = i;

            if (lastMinK != -1 && lastMaxK != -1) {
                count += Math.max(0, Math.min(lastMinK, lastMaxK) - invalidIdx);
            }
        }
        return count;
    }
}
