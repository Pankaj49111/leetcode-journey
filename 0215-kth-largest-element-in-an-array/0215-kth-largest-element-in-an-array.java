class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k); // kth largest == (n-k)th smallest
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) return nums[left];

        // Random pivot
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (pivotIndex == kSmallest) {
            return nums[pivotIndex];
        } else if (pivotIndex > kSmallest) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // Move pivot to the end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot back to its place
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
