class Solution {
    int rows, cols, cnt;
    int[][] grid;
    int result = 0;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        rows = grid.length; cols = grid[0].length;
        cnt=0;
        int x=0, y=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] != -1) cnt++;

                if(grid[i][j] == 1){
                    x = i; y = j;
                }
            }
        }
        dfs(x, y, cnt);
        return result;
    }

    void dfs(int r, int c, int count){
        if(r<0||r>=rows||c<0||c>=cols||grid[r][c]==-1) return;

        if(grid[r][c] == 2){
            if(count == 1) result++;

            return;
        }

        int tmp = grid[r][c];
        grid[r][c] = -1;

        dfs(r+1, c, count-1);
        dfs(r-1, c, count-1);
        dfs(r, c+1, count-1);
        dfs(r, c-1, count-1);

        grid[r][c] = tmp;
    }
}