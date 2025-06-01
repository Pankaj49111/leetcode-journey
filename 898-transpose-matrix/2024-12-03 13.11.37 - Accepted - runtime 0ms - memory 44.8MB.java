class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] response = new int[c][r];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i!=j){
                    response[j][i] = matrix[i][j];
                } else {
                    response[i][j] = matrix[i][j];
                }
            }
        }
        return response;
    }
}