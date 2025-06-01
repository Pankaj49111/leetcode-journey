class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0, num = 0, sign = 1;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                num = 10*num + Character.getNumericValue(c);
            } else if(c == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            } else if(c == '('){
                st.push(res);
                st.push(sign);

                sign = 1; 
                res = 0;
            } else if(c == ')'){
                res += sign * num;
                num = 0;

                res *= st.pop();
                res += st.pop();
            }
        }
        if(num != 0) res += sign * num;
        return res;
    }
}