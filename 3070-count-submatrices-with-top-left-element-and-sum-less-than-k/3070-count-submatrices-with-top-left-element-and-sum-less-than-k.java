class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prefix = new int[n][m];

        // build prefix sum matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                prefix[i][j] = grid[i][j];

                if (i > 0) prefix[i][j] += prefix[i - 1][j];
                if (j > 0) prefix[i][j] += prefix[i][j - 1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        int count = 0;

        // check all (0,0) → (i,j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (prefix[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}