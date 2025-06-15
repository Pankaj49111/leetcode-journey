class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // to keep track of unvisited columns in each row and unvisited rows in each column
        TreeSet<Integer>[] rowSet = new TreeSet[m];
        TreeSet<Integer>[] colSet = new TreeSet[n];

        for (int i = 0; i < m; i++) {
            rowSet[i] = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                rowSet[i].add(j);
            }
        }

        for (int j = 0; j < n; j++) {
            colSet[j] = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                colSet[j].add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        rowSet[0].remove(0);
        colSet[0].remove(0);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], steps = curr[2];

            // Check if we've reached the goal
            if (i == m - 1 && j == n - 1) return steps;

            // Right moves on the same row
            Integer col = rowSet[i].ceiling(j + 1);
            while (col != null && col <= j + grid[i][j]) {
                if (!visited[i][col]) {
                    visited[i][col] = true;
                    queue.offer(new int[]{i, col, steps + 1});
                    colSet[col].remove(i);
                }
                rowSet[i].remove(col);
                col = rowSet[i].ceiling(j + 1); // Get next eligible column
            }

            // Down moves on the same column
            Integer row = colSet[j].ceiling(i + 1);
            while (row != null && row <= i + grid[i][j]) {
                if (!visited[row][j]) {
                    visited[row][j] = true;
                    queue.offer(new int[]{row, j, steps + 1});
                    rowSet[row].remove(j);
                }
                colSet[j].remove(row);
                row = colSet[j].ceiling(i + 1); // Get next eligible row
            }
        }

        return -1; // No valid path
    }
}
