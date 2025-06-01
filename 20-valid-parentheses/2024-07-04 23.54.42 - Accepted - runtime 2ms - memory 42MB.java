class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        String open = "({[";
        for(char c : s.toCharArray()){
            if(open.contains(""+c)){
                st.push(c);
            } else {
                if(st.size() == 0) return false;

                if(c == ')' && st.peek() == '('){
                    st.pop();
                } else if(c == '}' && st.peek() == '{'){
                    st.pop();
                } else if(c == ']' && st.peek() == '['){
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}