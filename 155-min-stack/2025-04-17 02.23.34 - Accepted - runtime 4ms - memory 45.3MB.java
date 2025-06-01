class MinStack {
    private int[] stack;
    private int[] minStack;
    private int top;
    private int minTop;
    private final int MAX_SIZE = 30000;

    public MinStack() {
        stack = new int[MAX_SIZE];
        minStack = new int[MAX_SIZE];
        top = -1;
        minTop = -1;
    }

    public void push(int val) {
        stack[++top] = val;
        if (minTop == -1 || val <= minStack[minTop]) {
            minStack[++minTop] = val;
        }
    }

    public void pop() {
        if (stack[top] == minStack[minTop]) {
            minTop--;
        }
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[minTop];
    }
}
