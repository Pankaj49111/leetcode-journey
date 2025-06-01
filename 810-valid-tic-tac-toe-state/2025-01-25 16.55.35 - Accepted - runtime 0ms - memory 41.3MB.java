class Solution {
    public boolean validTicTacToe(String[] board) {
        int o = 0, x = 0;

        for(String str: board){
            for(char ch: str.toCharArray()){
                if(ch == 'O') o++;
                if(ch == 'X') x++;
            }
        }

        boolean winX = checkWin(board, 'X');
        boolean winO = checkWin(board, 'O');

        if(o>x) return false;
        if (!(x - o == 1 || x == o)) return false;

        
        if (winX && winO)
            return false;
        if (winX && x - o != 1)
            return false;
        if (winO && x - o != 0)
            return false;

        return true;
    }

    public boolean checkWin(String[] board, char c){
        for(String s : board){
            if(s.charAt(0) == c && s.charAt(1) == c && s.charAt(2) == c) return true;
        }

        for(int i=0; i<3; i++){
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        
        if((board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) ||
            (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c)) 
            return true;

        return false;
    }
}