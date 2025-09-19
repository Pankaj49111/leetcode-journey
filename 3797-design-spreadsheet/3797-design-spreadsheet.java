class Spreadsheet {
    int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        arr[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        arr[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        formula = formula.replace("=", "");
        String[] parts = formula.split("\\+");
        int res = 0;

        for (String part : parts) {
            part = part.toUpperCase();
            if (Character.isLetter(part.charAt(0))) {
                int[] pos = parseCell(part);
                res += arr[pos[0]][pos[1]];
            } else {
                res += Integer.parseInt(part);
            }
        }

        return res;
    }

    int[] parseCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */