class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Directions: up, down, left, right
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        // minEffort[r][c] keeps the minimum effort to reach cell (r,c)
        int[][] minEffort = new int[rows][cols];
        for (int[] row : minEffort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;

        // PriorityQueue: {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  // {effort, x, y}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0], x = curr[1], y = curr[2];

            // If we've reached the bottom-right cell, return the effort
            if (x == rows - 1 && y == cols - 1) {
                return effort;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                    int heightDiff = Math.abs(heights[x][y] - heights[newX][newY]);
                    int maxEffort = Math.max(effort, heightDiff);

                    // If this path is better than any previous to newX,newY
                    if (maxEffort < minEffort[newX][newY]) {
                        minEffort[newX][newY] = maxEffort;
                        pq.offer(new int[]{maxEffort, newX, newY});
                    }
                }
            }
        }

        return 0;
    }
}