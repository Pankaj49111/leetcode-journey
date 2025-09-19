class Spreadsheet {
    Map<String,Integer> map;
    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.remove(cell);
    }
    
    public int getValue(String formula) {
        String form = formula.replace("=","");
        
        String[] arr = form.split("\\+");
        int res = 0;
        for(String val: arr){
            if(Character.isLetter(val.charAt(0))){
                res += map.get(val) != null ? map.get(val) : 0;
            } else {
                res += Integer.parseInt(val);
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