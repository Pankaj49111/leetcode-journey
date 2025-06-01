class Solution {
    private static final int[][] DIRS = {
        {0, 1},  // Right
        {0, -1}, // Left
        {1, 0},  // Down
        {-1, 0}  // Up
    };

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] cell = deque.pollFirst();
            int x = cell[0], y = cell[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + DIRS[d][0];
                int ny = y + DIRS[d][1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int cost = (d == grid[x][y] - 1) ? 0 : 1;
                    if (dist[x][y] + cost < dist[nx][ny]) {
                        dist[nx][ny] = dist[x][y] + cost;
                        if (cost == 0)
                            deque.offerFirst(new int[]{nx, ny}); // same direction, low cost
                        else
                            deque.offerLast(new int[]{nx, ny}); // different direction, higher cost
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
