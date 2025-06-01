class Solution {
    public int minFlips(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int rFlips=0, cFlips=0;

        for(int i=0; i<r; i++){
            int left=0, right=c-1;

            while(left < right){
                if(grid[i][left] != grid[i][right]){
                    rFlips++;
                }
                left++; right--;
            }
        }

        for(int i=0; i<c; i++){
            int top=0, bottom=r-1;

            while(top<bottom){
                if(grid[top][i] != grid[bottom][i]){
                    cFlips++;
                }
                top++;bottom--;
            }
        }

        return Math.min(rFlips, cFlips);
    }
}