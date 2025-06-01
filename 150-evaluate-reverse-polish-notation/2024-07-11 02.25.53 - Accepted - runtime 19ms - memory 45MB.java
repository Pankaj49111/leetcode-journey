class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens){
            if(isNumeric(s)){
                st.push(Integer.parseInt(s));
            } else {
                if(st.size()>1){
                    int b = st.pop();
                    int a = st.pop();
                    switch(s){
                        case "+": st.push(a+b);
                            break;
                        case "-": st.push(a-b);
                            break;
                        case "*": st.push(a*b);
                            break;
                        case "/": st.push(a/b);
                            break;
                    }
                }
            }
        }
        return st.pop();
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}