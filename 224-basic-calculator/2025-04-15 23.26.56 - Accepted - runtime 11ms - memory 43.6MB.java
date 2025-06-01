import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;   // Current number we are building
        int res = 0;
        int sign = 1;  // 1 means positive, -1 means negative
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }

            // If we encounter an operator or end of the string
            if (c == '+' || c == '-' || c == '(' || c == ')' || i == n - 1) {
                if (c == '+' || c == '-') {
                    // Add previous number to result with the previous sign
                    res += sign * num;
                    num = 0; // Reset number
                    sign = (c == '+') ? 1 : -1; // Update sign for the next number
                }

                // If we encounter a '(', push the current result and sign to the stack
                if (c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;   // Reset the result for the new sub-expression
                    sign = 1;  // Reset sign to positive for the new sub-expression
                }

                // If we encounter a ')', pop from stack and add the result
                if (c == ')') {
                    res += sign * num;
                    num = 0; // Reset num for the next number
                    res *= stack.pop(); // Apply the sign before the parentheses
                    res += stack.pop(); // Add the result before the parentheses
                }
            }
        }

        // After loop, add the last number if any
        if (num != 0) {
            res += sign * num;
        }

        return res;
    }
}
