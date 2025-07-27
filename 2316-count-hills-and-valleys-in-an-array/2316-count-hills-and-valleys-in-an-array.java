class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;

            // Find previous non-equal value
            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }

            // Find next non-equal value
            int right = i + 1;
            while (right < n && nums[right] == nums[i]) {
                right++;
            }

            if (left >= 0 && right < n) {
                if (nums[left] < nums[i] && nums[right] < nums[i]) {
                    count++; // hill
                } else if (nums[left] > nums[i] && nums[right] > nums[i]) {
                    count++; // valley
                }
            }
        }

        return count;
    }
}
