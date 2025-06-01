class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int perimeter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !vis[r][c]) {
                    perimeter += dfs(grid, vis, r, c);
                }
            }
        }

        return perimeter;
    }

    private int dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 1; 
        }
        if (vis[r][c]) {
            return 0;
        }

        vis[r][c] = true;

        return (dfs(grid, vis, r + 1, c) +
                dfs(grid, vis, r - 1, c) +
                dfs(grid, vis, r, c + 1) +
                dfs(grid, vis, r, c - 1));
    }
}