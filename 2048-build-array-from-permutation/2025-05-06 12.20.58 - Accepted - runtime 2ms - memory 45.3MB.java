class Solution {

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // Build the final value on the first iteration
        for (int i = 0; i < n; ++i) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        // Modified to final value on the second iteration
        for (int i = 0; i < n; ++i) {
            nums[i] /= 1000;
        }

        // First pass: encode both old and new values into nums[i]
        // for (int i = 0; i < n; i++) {
        //     nums[i] = nums[i] + n * (nums[nums[i]] % n);
        // }

        // // Second pass: extract the new values
        // for (int i = 0; i < n; i++) {
        //     nums[i] = nums[i] / n;
        // }
        return nums;
    }
}