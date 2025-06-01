class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char ch = board[i][j];
                if (ch != '.')
                    if(!seen.add(ch+"in row"+i) || 
                       !seen.add(ch+"in col"+j) || 
                       !seen.add(ch+"in block"+i/3+"-"+j/3)) 
                        return false;
            }
        }
        return true;
    }
}