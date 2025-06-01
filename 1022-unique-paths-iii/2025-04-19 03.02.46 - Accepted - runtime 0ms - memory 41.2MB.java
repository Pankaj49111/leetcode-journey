class Solution {
    public int uniquePathsIII(int[][] grid) {
        int r=0, c=0, zero=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0) zero++;
                else if(grid[i][j] == 1) {
                    r = i; c = j;
                }
            }
        }
        return backtrack(grid, r, c, zero);
    }

    int backtrack(int[][] grid, int r, int c, int zero) {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == -1) return 0;

        if(grid[r][c] == 2) return zero == -1 ? 1 : 0;

        grid[r][c] = -1;
        zero--;

        int count = backtrack(grid, r+1, c, zero) + backtrack(grid, r, c+1, zero) +
                    backtrack(grid, r-1, c, zero) + backtrack(grid, r, c-1, zero);

        grid[r][c] = 0; 
        zero++;

        return count;
    }
    
}