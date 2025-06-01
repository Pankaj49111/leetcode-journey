class Solution {
    public int countNegatives(int[][] grid) {
        int count=0, r = grid.length, c = grid[0].length;
        int row=0, col = c-1;

        while(row < r && col>=0){
            if(grid[row][col] < 0){
                count += r - row;
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}