class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] mat = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = board[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                checkAndUpdate(mat, mat[i][j], board, i, j, n, m);
            }
        }
    }

    void checkAndUpdate(int[][] mat, int val, int[][] board, int i, int j, int n, int m){
        int count = 0;
        int top = i-1 < 0 ? 0 : i-1;
        int left = j-1 < 0 ? 0 : j-1;
        int right = j+1 >= m ? m-1 : j+1;
        int bott = i+1 >= n ? n-1 : i+1;

        for(int r=top; r<=bott; r++){
            for(int c=left; c<=right; c++){
                if(r==i && c==j) continue;

                if(mat[r][c] == 1) count++;
            }
        }
        
        if(val == 1){
            if(count < 2) {
                board[i][j] = 0;
            } else if(count <= 3){
                board[i][j] = 1;
            } else {
                board[i][j] = 0;
            }
        } else {
            if(count == 3) board[i][j] = 1;
        }
    }

}