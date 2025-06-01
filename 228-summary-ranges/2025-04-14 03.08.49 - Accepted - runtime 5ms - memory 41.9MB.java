class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int start = nums[i];

            // Move forward while consecutive numbers found
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            int end =  nums[i];

            if (start == end) {
                ranges.add(String.valueOf(start));
            } else {
                ranges.add(start + "->" + end);
            }

            i++;
        }

        return ranges;
    }
}