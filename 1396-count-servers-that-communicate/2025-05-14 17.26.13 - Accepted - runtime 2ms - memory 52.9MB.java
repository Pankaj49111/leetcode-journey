class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[] rcount = new int[r];
        int[] ccount = new int[c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    rcount[i]++;
                    ccount[j]++;
                }
            }
        }

        int result = 0; 
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1 && (rcount[i] > 1 || ccount[j] > 1)) result++;
            }
        }
        return result;
    }
}