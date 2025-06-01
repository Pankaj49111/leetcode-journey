class Solution {
    public int diagonalSum(int[][] mat) {
        int r=mat.length;
        if(r==1) return mat[r-1][r-1];
        int lsum=0, rsum=0;
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<r; j++) {
                if(i==j) lsum += mat[i][j];
                
                else if((i+j)==r-1) rsum+= mat[i][j];
            }
        }
        
        return lsum+rsum;
    }
}