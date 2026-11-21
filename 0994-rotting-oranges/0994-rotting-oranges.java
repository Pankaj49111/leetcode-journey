class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int fresh=0;

        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int min = -1;

        while(!q.isEmpty()){
            int size = q.size();
            min++;

            while(size-- > 0){
                int[] curr = q.poll();

                for(int[] d: dirs){
                    int nr = d[0]+curr[0];
                    int nc = d[1]+curr[1];

                    if(nr<0 || nr>=n || nc<0 || nc>=m || grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                    fresh--;
                }
            }
        }
        return fresh == 0? min : -1;
    }
}