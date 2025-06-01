class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, r, c, 0, word)) return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, int r, int c, int idx, String word){
        if(idx == word.length()) return true;

        if(i<0 || j<0 || i>=r || j>=c || board[i][j] != word.charAt(idx)) return false;

        char tmp = board[i][j];
        board[i][j] = '#';

        boolean res = dfs(board, i+1, j, r, c, idx+1, word) || dfs(board, i, j+1, r, c, idx+1, word) ||
                      dfs(board, i-1, j, r, c, idx+1, word) ||  dfs(board, i, j-1, r, c, idx+1, word);

        board[i][j] = tmp;
        return res;
    }
}