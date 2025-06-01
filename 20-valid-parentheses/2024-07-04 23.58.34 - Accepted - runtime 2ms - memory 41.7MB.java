class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> st = new Stack<>();
        String open = "({[";
        for(char c : s.toCharArray()){
            if(open.contains(""+c)){
                st.push(c);
            } else {
                if(st.isEmpty()) return false;

                if((c == ')' && st.peek() != '(') 
                || (c == '}' && st.peek() != '{') 
                || (c == ']' && st.peek() != '[')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}