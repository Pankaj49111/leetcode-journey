class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        int i = 0;
        while (i < n) {
            while (i < n && nums[i] == 0) i++;
            if (i >= n) break;

            int start = i;
            int negCount = 0;
            int firstNeg = -1, lastNeg = -1;

            while (i < n && nums[i] != 0) {
                if (nums[i] < 0) {
                    if (firstNeg == -1) firstNeg = i;
                    lastNeg = i;
                    negCount++;
                }
                i++;
            }
            int end = i - 1; // inclusive

            if (negCount % 2 == 0) {
                maxLen = Math.max(maxLen, end - start + 1);
            } else {
                int len1 = end - firstNeg;
                
                int len2 = lastNeg - start;
                maxLen = Math.max(maxLen, Math.max(len1, len2));
            }
        }
        return maxLen;
    }
}
