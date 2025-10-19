class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];     // frequency
        boolean[] inStack = new boolean[26];  // track presence
        
        for (char c : s.toCharArray())
            count[c - 'a']++;
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--; // used once now
            
            if (inStack[c - 'a']) continue; // already included
            
            // Maintain lexicographically smallest
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        // Build result
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        
        return sb.toString();
    }
}
