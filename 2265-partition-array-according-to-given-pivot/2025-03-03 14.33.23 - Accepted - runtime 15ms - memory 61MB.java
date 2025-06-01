class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> larr = new ArrayList<>();
        List<Integer> garr = new ArrayList<>();
        List<Integer> earr = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                larr.add(num);
            } else if (num > pivot) {
                garr.add(num);
            } else {
                earr.add(num);
            }
        }

        // int[] result = new int[nums.length];
        int index = 0;

        for (int num : larr) {
            nums[index++] = num;
        }
        for (int num : earr) {
            nums[index++] = num;
        }
        for (int num : garr) {
            nums[index++] = num;
        }
        
        return nums;
    }
}