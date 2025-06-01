class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            diff[left] += 1;
            if (right + 1 < n) {
                diff[right + 1] -= 1;
            }
        }

        // System.out.println(Arrays.toString(diff));

        int[] canUse = new int[n];
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            canUse[i] = current;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > canUse[i]) {
                return false;
            }
        }

        return true;
    }
}