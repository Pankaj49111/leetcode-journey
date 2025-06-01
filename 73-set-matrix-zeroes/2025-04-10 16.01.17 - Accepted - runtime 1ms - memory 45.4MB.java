class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int[][] zero = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] == 0){
                    zero[i][j] = -1;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(zero[i][j] == -1){
                    makezero(matrix, i, j, r, c);
                }
            }
        }
        // System.out.println(Arrays.toString(zero));
    }

    void makezero(int[][] matrix, int i, int j, int r, int c){
        for(int q = 0; q < c; q++){
            matrix[i][q] = 0;
        }
        for(int q = 0; q < r; q++){
            matrix[q][j] = 0;
        }
    }
}