class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negatives = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negatives++;
                int absVal = Math.abs(val);
                sum += absVal;
                minAbs = Math.min(minAbs, absVal);
            }
        }

        if (negatives % 2 == 1) {
            sum -= 2L * minAbs;
        }

        return sum;
    }
}
