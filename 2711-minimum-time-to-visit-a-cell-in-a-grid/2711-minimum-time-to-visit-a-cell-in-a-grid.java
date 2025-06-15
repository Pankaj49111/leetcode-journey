class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // can't move
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] time = new int[m][n];

        for(int[] t: time){
            Arrays.fill(t, Integer.MAX_VALUE);
        }

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));
        pq.offer(new int[]{0,0,0});
        time[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], t = curr[2];

            if(r == m-1 && c == n-1) return t;

            for(int[] d: dirs){
                int nr = d[0]+r;
                int nc = d[1]+c;

                if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                    int wait = Math.max(grid[nr][nc], t+1);

                    // if difference is even or > 1
                    if((wait-t)%2 == 0) wait++;

                    if(wait < time[nr][nc]){
                        time[nr][nc] = wait;
                        pq.offer(new int[]{nr, nc, wait});
                    }
                }
            }
        }
        return -1;
    }
}