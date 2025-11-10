class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int curr = (i < n) ? nums[i] : 0; 
            // sentinel 0 to flush stack
            
            while (!stack.isEmpty() && curr < stack.peek()) {
                int top = stack.pop();
                // avoid counting duplicates
                while (!stack.isEmpty() && stack.peek() == top) stack.pop();
                ops++;
            }
            
            if (curr != 0) stack.push(curr);
        }
        
        return ops;
    }
}
