class Solution {
    public void sortColors(int[] nums) {
        int x = 0, y = nums.length - 1;
        int i = 0;

        while (i <= y) {
            if (nums[i] == 0) {
                swap(nums, i, x);
                x++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, y);
                y--;
            } else {
                i++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
