class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1;  // count the reference point itself
            int currMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;  // exact same point
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    if (dx < 0) {
                        dx *= -1;
                        dy *= -1;
                    }

                    String key = dy + "/" + dx;
                    slopeMap.put(key, slopeMap.getOrDefault(key, 0) + 1);
                    currMax = Math.max(currMax, slopeMap.get(key));
                }
            }

            max = Math.max(max, currMax + duplicate);
        }

        return max;
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
