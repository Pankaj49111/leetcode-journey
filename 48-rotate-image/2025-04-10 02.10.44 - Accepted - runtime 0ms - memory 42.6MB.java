class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        // transpose
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //reverse individual array
        for(int[] mat: matrix){
            int i=0, j=mat.length-1;
            while(i<j){
                int tmp = mat[i];
                mat[i] = mat[j];
                mat[j] = tmp;

                i++; j--;
            }
        }
    }
}