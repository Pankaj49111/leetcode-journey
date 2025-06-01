class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark all 'O's connected to border with temporary marker 'T'
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);       // Left border
            dfs(board, i, n - 1);   // Right border
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);       // Top border
            dfs(board, m - 1, j);   // Bottom border
        }

        // Step 2: Convert the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Captured region
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // Restore border-connected region
                }
            }
        }
    }

    // DFS to mark connected 'O's with 'T'
    private void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;

        board[i][j] = 'T'; // Temporarily mark this cell

        // Explore all 4 directions
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
