class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            } else if(ch == ')'){
                if(st.isEmpty()){
                    sb.setCharAt(i, ' ');
                } else {
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()) sb.setCharAt(st.pop(), ' ');

        return sb.toString().replace(" ", "");
    }
}