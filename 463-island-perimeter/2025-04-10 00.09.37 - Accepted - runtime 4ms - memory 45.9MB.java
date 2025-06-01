class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If the cell is land
                if (grid[r][c] == 1) {
                    if (r == 0 || grid[r - 1][c] == 0) perimeter++; // Check above
                    if (r == rows - 1 || grid[r + 1][c] == 0) perimeter++; // Check below
                    if (c == 0 || grid[r][c - 1] == 0) perimeter++; // Check left
                    if (c == cols - 1 || grid[r][c + 1] == 0) perimeter++; // Check right
                }
            }
        }

        return perimeter;
    }
}
