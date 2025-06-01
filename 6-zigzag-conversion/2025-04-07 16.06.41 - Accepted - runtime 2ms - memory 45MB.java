class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder result = new StringBuilder();
        
        int step = 2 * (numRows - 1);
        
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += step) {
                result.append(s.charAt(i));
                
                if (row != 0 && row != numRows - 1) {
                    int diagonal = i + step - 2 * row;
                    if (diagonal < s.length()) {
                        result.append(s.charAt(diagonal));
                    }
                }
            }
        }
        
        return result.toString();
    }
}
