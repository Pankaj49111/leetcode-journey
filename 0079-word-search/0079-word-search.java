class Solution {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == ch[0]){
                    if(dfs(board, ch, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int idx, int r, int c){
        if(idx == word.length) return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] != word[idx]) return false;

        char tmp = board[r][c];
        board[r][c] = '#';

        boolean res = dfs(board, word, idx+1, r+1, c) ||
                    dfs(board, word, idx+1, r-1, c) ||
                    dfs(board, word, idx+1, r, c+1) ||
                    dfs(board, word, idx+1, r, c-1);

        board[r][c] = tmp;
        return res;
    }
}