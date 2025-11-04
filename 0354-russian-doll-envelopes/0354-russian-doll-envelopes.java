class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort by width asc, height desc
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];  // descending height for same width
            return a[0] - b[0];
        });

        // Step 2: Extract heights
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++)
            heights[i] = envelopes[i][1];

        // Step 3: Find LIS on heights
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == lis.size())
                lis.add(num);
            else
                lis.set(idx, num);
        }
        return lis.size();
    }
}
