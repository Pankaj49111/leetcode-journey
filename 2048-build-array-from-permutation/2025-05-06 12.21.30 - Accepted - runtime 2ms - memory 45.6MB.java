class Solution {

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // First pass: encode both old and new values into nums[i]
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        // Second pass: extract the new values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;
    }
}