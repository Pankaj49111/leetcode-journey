class Solution {
    public String convert(String s, int numRows) {
        // Edge case: If there is only one row, return the string as is
        if (numRows == 1) return s;
        
        // Initialize an array of StringBuilder to store each row's characters
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        // Variables to track the current row and the direction (up or down)
        int currentRow = 0;
        boolean goingDown = false;
        
        // Loop through each character in the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // If we're at the top or bottom row, we need to change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all the rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
