class Solution {
    private static final int[][] DIRS = {
        {0, 1},  // Right
        {0, -1}, // Left
        {1, 0},  // Down
        {-1, 0}  // Up
    };

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {cost, x, y}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0], x = curr[1], y = curr[2];
            if (x == m - 1 && y == n - 1) return currCost;

            for (int d = 0; d < 4; d++) {
                int nx = x + DIRS[d][0];
                int ny = y + DIRS[d][1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    // Is this direction the same as the current cell's sign?
                    int expectedDir = grid[x][y] - 1;
                    int newCost = currCost + (d == expectedDir ? 0 : 1);

                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }
        return -1; // Should never happen if a path can always be made
    }
}
