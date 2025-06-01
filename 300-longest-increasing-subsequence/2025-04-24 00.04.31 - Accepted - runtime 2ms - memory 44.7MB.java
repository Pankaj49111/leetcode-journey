class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int idx = binarySearch(tail, 0, size, num);
            tail[idx] = num;

            if (idx == size) size++;
        }

        return size;
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
