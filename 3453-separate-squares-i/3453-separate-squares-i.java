class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double total = 0;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
            total += (double) s[2] * s[2];
        }

        double target = total / 2.0;

        for (int iter = 0; iter < 60; iter++) {
            double mid = (low + high) / 2;
            double below = areaBelow(squares, mid);

            if (below < target)
                low = mid;
            else
                high = mid;
        }

        return low;
    }

    private double areaBelow(int[][] squares, double y) {
        double area = 0;
        for (int[] s : squares) {
            double bottom = s[1];
            double top = s[1] + s[2];
            double l = s[2];

            if (y <= bottom) continue;
            else if (y >= top) area += l * l;
            else area += l * (y - bottom);
        }
        return area;
    }
}
