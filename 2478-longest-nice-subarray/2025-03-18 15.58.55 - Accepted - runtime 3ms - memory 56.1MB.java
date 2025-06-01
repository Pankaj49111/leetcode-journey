class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, usedBits = 0, max = 0;

        // Iterate through the array with the right pointer 'r'
        for (int r = 0; r < nums.length; r++) {
            // Check if the current number (nums[r]) shares bits with the current window.
            // If it shares bits, adjust the left pointer 'l' to shrink the window
            // until the condition is satisfied again.
            while ((usedBits & nums[r]) != 0) {
                usedBits ^= nums[l];  // Remove the leftmost element's bits from 'usedBits'
                l++;  // Shrink the window by moving the left pointer to the right
            }

            // Include the current element (nums[r]) into the window
            usedBits |= nums[r];  // Add the bits of the current number to 'usedBits'
            
            // Update the result (max) by comparing the current window size (r - l + 1)
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}