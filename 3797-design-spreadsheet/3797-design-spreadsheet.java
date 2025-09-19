class Spreadsheet {
    int[][] arr;
    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        arr[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        arr[row][col] = 0;
    }
    
    public int getValue(String formula) {
        formula = formula.replace("=", "");
        String[] form = formula.split("\\+");
        int res=0;
        for(String cell: form){
            cell = cell.toUpperCase();
            if(Character.isLetter(cell.charAt(0))){
                int col = cell.charAt(0) - 'A';
                int row = Integer.parseInt(cell.substring(1)) - 1;
                res += arr[row][col];
            } else {
                res += Integer.parseInt(cell);
            }
        }
        return res;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */