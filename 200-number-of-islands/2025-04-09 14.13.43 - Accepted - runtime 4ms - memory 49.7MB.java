class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] vis = new boolean[r][c];
        int cnt=0;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, vis, i, j, r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(char[][] grid, boolean[][] vis, int i, int j, int r, int c) {
        if(i<0 || j<0 || i>=r || j>=c || vis[i][j] || grid[i][j] == '0') return;

        vis[i][j] = true;

        dfs(grid, vis, i+1, j, r, c);
        dfs(grid, vis, i-1, j, r, c);
        dfs(grid, vis, i, j+1, r, c);
        dfs(grid, vis, i, j-1, r, c);
    }
}