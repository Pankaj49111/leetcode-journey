class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
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
                    int ni = curr[0]+d[0];
                    int nj = curr[1]+d[1];

                    if(ni<0||nj<0||ni>=m||nj>=n||grid[ni][nj]!=1) continue;

                    grid[ni][nj] = 2;
                    q.offer(new int[]{ni,nj});
                    fresh--;
                }
            }
        }
        return fresh == 0 ? min : -1;
    }
}