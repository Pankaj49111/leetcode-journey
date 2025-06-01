class Solution {
    public int calPoints(String[] ops) {
        int sum=0, len = ops.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){
            if(ops[i].equals("C")){
                st.pop();
            } else if(ops[i].equals("D")){
                st.push(2*st.peek());
            } else if(ops[i].equals("+")){
                int pop = st.pop();
                int peek = st.peek();
                st.push(pop);
                st.push(pop+peek);
            } else {
                st.push(Integer.parseInt(ops[i]));
            }
        }

        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}