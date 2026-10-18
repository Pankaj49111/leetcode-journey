class MinStack {
    Deque<Integer> st;
    Deque<Integer> minSt;

    public MinStack() {
        st = new ArrayDeque<>();
        minSt = new ArrayDeque<>();    
    }
    
    public void push(int value) {
        st.push(value);
        if(minSt.isEmpty() || minSt.peek() >= value){
            minSt.push(value);
        }
    }
    
    public void pop() {
        int rem = st.pop();

        if(rem == minSt.peek()){
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */