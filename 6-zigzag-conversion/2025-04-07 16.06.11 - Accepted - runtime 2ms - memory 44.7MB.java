class Solution {
    public String convert(String s, int numRows) {
        // Edge case: If there is only one row, return the string as is
        if (numRows == 1) return s;
        
        // Initialize a StringBuilder to hold the final result
        StringBuilder result = new StringBuilder();
        
        // Step 1: Calculate the step size (intervals between characters)
        int step = 2 * (numRows - 1);
        
        // Step 2: Iterate over each row (0 to numRows-1)
        for (int row = 0; row < numRows; row++) {
            // Step 3: For each row, find the characters that belong to that row
            for (int i = row; i < s.length(); i += step) {
                // Always append the current character (direct)
                result.append(s.charAt(i));
                
                // If we're not on the top or bottom row, we also need to add the diagonal character
                // The diagonal character is at position i + (step - 2 * row)
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
