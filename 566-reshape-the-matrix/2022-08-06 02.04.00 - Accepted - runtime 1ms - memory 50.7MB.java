class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length, cols = mat[0].length;
        if (r*c != rows*cols) return mat;
        int[] oneD = new int[rows*cols];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                oneD[cols*i+j]=mat[i][j];
            }
        }

        int[][] newMat = new int[r][c];
        for(int i=0; i<r*c; i++) {
            newMat[i/c][i%c] = oneD[i];
        }
        return newMat;
    }
}