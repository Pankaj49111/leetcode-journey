class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;

        int[][] newMat = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                newMat[i][j] = matrix[j][i];
            }
        }

        for(int[] mat: newMat){
            int i=0, j=mat.length-1;
            while(i<j){
                int tmp = mat[i];
                mat[i] = mat[j];
                mat[j] = tmp;

                i++; j--;
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = newMat[i][j];
            }
        }
    }
}