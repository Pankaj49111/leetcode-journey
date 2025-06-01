class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, rows, cols)) closedIslands++;
                }
            }
        }

        return closedIslands;
    }

    boolean dfs(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) return false;
        if (grid[i][j] != 0) return true;

        grid[i][j] = -1;

        // Check all 4 directions, and keep track of whether all are closed
        boolean up = dfs(grid, i - 1, j, rows, cols);
        boolean down = dfs(grid, i + 1, j, rows, cols);
        boolean left = dfs(grid, i, j - 1, rows, cols);
        boolean right = dfs(grid, i, j + 1, rows, cols);

        return up && down && left && right;
    }
}
