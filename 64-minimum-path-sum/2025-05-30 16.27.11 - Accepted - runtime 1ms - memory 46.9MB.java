class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        return dfs(grid, 0, 0, memo);
    }

    int dfs(int[][] grid, int r, int c, Integer[][] memo){
        int m = grid.length, n = grid[0].length;

        if(r == m-1 && c == n-1) return grid[r][c];

        if(r >= m || c >= n) return Integer.MAX_VALUE;

        if(memo[r][c] != null) return memo[r][c];

        int right = dfs(grid, r, c+1, memo);
        int down = dfs(grid, r+1, c, memo);

        memo[r][c] = grid[r][c] + Math.min(right, down);
        return memo[r][c];
    }
}