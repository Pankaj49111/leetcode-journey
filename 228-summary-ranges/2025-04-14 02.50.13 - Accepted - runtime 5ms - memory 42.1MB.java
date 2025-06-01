class Solution {
    public List<String> summaryRanges(int[] nums) {
        Set<Integer> numSet = new TreeSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        List<Integer> sortedNums = new ArrayList<>(numSet);
        List<String> ranges = new ArrayList<>();

        int i = 0;
        while (i < sortedNums.size()) {
            int start = sortedNums.get(i);

            while (i + 1 < sortedNums.size() && 
                   sortedNums.get(i + 1) == sortedNums.get(i) + 1) {
                i++;
            }

            int end = sortedNums.get(i);

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