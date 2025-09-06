class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;
        for (int[] q : queries) {
            total += calc(q[0], q[1]);
        }
        return total;
    }

    private long calc(long l, long r) {
        long stepsSum = 0;
        long start = 1;
        int step = 1;

        while (start <= r) {
            long end = start * 4 - 1; // interval [start, end]
            long left = Math.max(l, start);
            long right = Math.min(r, end);

            if (left <= right) {
                long count = right - left + 1;
                stepsSum += count * step;
            }

            start *= 4;
            step++;
        }

        return (stepsSum + 1) / 2; // ceiling division
    }
}
