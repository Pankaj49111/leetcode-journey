class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            Set<Character> rows = new HashSet<Character>();
            Set<Character> cols = new HashSet<Character>();
            Set<Character> grid = new HashSet<Character>();

            for(int j=0; j<9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;

                int rIdx = 3*(i/3);
                int cIdx = 3*(i%3);

                if(board[rIdx + j/3][cIdx + j%3] != '.' && !grid.add(board[rIdx + j/3][cIdx + j%3]))
                    return false;
            }
        }
        return true;
    }
}