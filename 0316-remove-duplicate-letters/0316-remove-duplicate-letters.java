class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // frequency of each char
        boolean[] inStack = new boolean[26]; // track if already in result

        for (char c : s.toCharArray()) count[c - 'a']++;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']--; // this char is now seen once

            if (inStack[c - 'a']) continue; // already used

            // while top is lexicographically greater and still appears later → pop it
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}
