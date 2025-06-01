class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flat = flatten(board);
        
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // {square, moves}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int moves = curr[1];
            
            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > n * n) continue;

                // Snake or ladder
                if (flat[next] != -1) {
                    next = flat[next];
                }

                if (next == n * n) return moves + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] flatten(int[][] board) {
        int n = board.length;
        int[] flat = new int[n * n + 1];
        Arrays.fill(flat, -1);

        int index = 1;
        boolean togglePath = true;

        for (int r = n - 1; r >= 0; r--) { // starting from [n-1, 0]
            if (togglePath) {
                for (int c = 0; c < n; c++) {
                    flat[index++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    flat[index++] = board[r][c];
                }
            }
            togglePath = !togglePath;
        }

        return flat;
    }
}
