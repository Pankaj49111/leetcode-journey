class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;       // potential first
                right = mid - 1;    // search left half
            } else if (nums[mid] < target) {
                left = mid + 1;     // move right
            } else {
                right = mid - 1;    // move left
            }
        }

        return result;
    }

    int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;       // potential last
                left = mid + 1;     // search right half
            } else if (nums[mid] < target) {
                left = mid + 1;     // move right
            } else {
                right = mid - 1;    // move left
            }
        }

        return result;
    }
}
    