class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length, cols = mat[0].length;
        if (r*c != rows*cols) return mat;
        int[] arr = new int[rows*cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                arr[cols*i+j]=mat[i][j];
            }
        }
        
        int[][] newMat = new int[r][c];
        for(int i=0; i<r*c; i++) {
            newMat[i/c][i%c] = arr[i];
        }
        return newMat;
    }
}