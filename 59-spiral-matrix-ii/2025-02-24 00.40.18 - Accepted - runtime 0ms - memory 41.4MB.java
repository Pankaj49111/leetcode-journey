class Solution {
    public int[][] generateMatrix(int n) {
        /*
        00 01 02    1 2 3
        10 11 12    8 9 4
        20 21 22    7 6 5

        00 01 02 12 22 21 20 10 11
        1  2  3  4  5  6  7  8  9
        */
        int num = 1;
        int[][] mat  = new int[n][n];

        int top=0, left=0;
        int bot=n-1, right=n-1;

        while(top <= bot){
            for(int i=left; i<=right; i++){
                mat[top][i] = num++;
            }
            top++;

            for(int i=top; i<=bot; i++){
                mat[i][right] = num++;
            }
            right--;

            for(int i=right; i>=left; i--){
                mat[bot][i] = num++;
            }
            bot--;

            for(int i=bot; i>=top; i--){
                mat[i][left] = num++;
            }
            left++;
        }
        return mat;
    }
}