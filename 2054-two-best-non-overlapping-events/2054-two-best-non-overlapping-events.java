class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort by end time
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int n = events.length;
        int[] ends = new int[n];
        int[] maxVal = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = events[i][1];
            maxVal[i] = events[i][2];
            if (i > 0) {
                maxVal[i] = Math.max(maxVal[i], maxVal[i - 1]);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int val = events[i][2];
            int start = events[i][0];

            // Binary search last event ending < start
            int j = binarySearch(ends, start - 1);
            if (j != -1) {
                val += maxVal[j];
            }
            ans = Math.max(ans, val);
        }
        return ans;
    }

    private int binarySearch(int[] ends, int target) {
        int l = 0, r = ends.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ends[mid] <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
