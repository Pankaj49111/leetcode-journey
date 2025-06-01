class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grid = new HashSet[9];

        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c] == '.') continue;

                char value = board[r][c];
                int boxIdx = (r/3)*3 + (c/3);

                if(rows[r].contains(value) || cols[c].contains(value) || grid[boxIdx].contains(value)){
                    return false;
                }

                rows[r].add(value);
                cols[c].add(value);
                grid[boxIdx].add(value);
            }
        }
        return true;
    }
}