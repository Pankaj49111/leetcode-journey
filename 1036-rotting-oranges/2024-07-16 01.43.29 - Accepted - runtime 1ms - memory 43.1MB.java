class Pair{
    int i;
    int j;
    int time;

    Pair(int _i, int _j, int _time){
        this.i = _i;
        this.j = _j;
        this.time = _time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt=0;

        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int x[] = {1,0,-1,0}; 
        int y[] = {0,1,0,-1};
        int ans = 0, s = 0;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            ans = Math.max(pair.time, ans);

            for(int i=0; i<4; i++){
                int nr = pair.i + x[i];
                int nc = pair.j + y[i];

                if(nr >= 0 && nc >= 0 && nr<n && nc<m && grid[nr][nc] == 1){
                    q.add(new Pair(nr, nc, pair.time + 1));
                    grid[nr][nc] = 2;
                    s++;
                }
            }
        }
        if(s == cnt) return ans;
        else return -1;
    }
}