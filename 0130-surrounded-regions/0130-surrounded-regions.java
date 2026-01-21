class Solution {
    void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    boolean[][] visited = new boolean[m][n];
                    List<int[]> region = new ArrayList<>();
                    if (!touchesBorder(board, i, j, visited, region)) {
                        for (int[] cell : region) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    boolean touchesBorder(char[][] board, int i, int j,
                        boolean[][] visited, List<int[]> region) {
        int m = board.length, n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (visited[i][j] || board[i][j] == 'X') return false;

        visited[i][j] = true;
        region.add(new int[]{i, j});

        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
            return true;
        }

        return touchesBorder(board, i + 1, j, visited, region)
            || touchesBorder(board, i - 1, j, visited, region)
            || touchesBorder(board, i, j + 1, visited, region)
            || touchesBorder(board, i, j - 1, visited, region);
    }

}