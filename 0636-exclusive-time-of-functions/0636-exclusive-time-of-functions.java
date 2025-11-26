class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];  // Array to store the exclusive time for each function.
        Stack<Integer> stack = new Stack<>();  // Stack to simulate the call stack.
        int prevTime = 0;  // Keeps track of the previous timestamp.
        
        for (String log : logs) {
            String[] parts = log.split(":");  // Split the log by ":"
            int functionId = Integer.parseInt(parts[0]);  // Function ID
            String action = parts[1];  // "start" or "end"
            int timestamp = Integer.parseInt(parts[2]);  // Timestamp

            if (action.equals("start")) {
                // If it's a start, push the function ID onto the stack
                if (!stack.isEmpty()) {
                    // Add the time spent by the function on the top of the stack to its result
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(functionId);  // Push the current function to the stack
                prevTime = timestamp;  // Update the previous time to the current timestamp
            } else {
                // If it's an end, calculate the time for this function
                result[functionId] += timestamp - prevTime + 1;  // Add the current time span
                stack.pop();  // Pop the function from the stack
                prevTime = timestamp + 1;  // Set prevTime to the next timestamp after this function ends
            }
        }

        return result;
    }
}
