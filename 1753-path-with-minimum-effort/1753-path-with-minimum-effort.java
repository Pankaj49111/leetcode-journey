class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int left = 0, right = 1_000_000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[rows][cols];

            if (dfs(heights, 0, 0, visited, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // DFS to check if a path exists with effort <= limit
    private boolean dfs(int[][] heights, int r, int c, boolean[][] visited, int limit) {
        int rows = heights.length, cols = heights[0].length;

        if (r == rows - 1 && c == cols - 1) return true;
        visited[r][c] = true;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]) {
                int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                if (diff <= limit && dfs(heights, nr, nc, visited, limit)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Optionally, use BFS instead of DFS for better stack safety
    private boolean bfs(int[][] heights, int limit) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == rows - 1 && c == cols - 1) return true;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    if (diff <= limit) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }
}
