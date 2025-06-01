class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int r, int c, int idx, String word){
        if(idx == word.length()) return true; 
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c] != word.charAt(idx)) return false;

        char tmp = board[r][c];
        board[r][c] = '#'; // marking visited

        boolean res=dfs(board, r+1, c, idx+1, word) ||
                    dfs(board, r-1, c, idx+1, word) ||
                    dfs(board, r, c+1, idx+1, word) ||
                    dfs(board, r, c-1, idx+1, word);

        board[r][c] = tmp; // backtrack
        return res;

    }
}