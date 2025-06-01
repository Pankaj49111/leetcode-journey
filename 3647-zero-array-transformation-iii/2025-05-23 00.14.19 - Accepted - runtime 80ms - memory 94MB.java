import java.util.*;

public class Solution {

    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        
        // Step 1: Sort queries by their start index
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Max-heap to keep track of end indices of active queries
        PriorityQueue<Integer> activeQueries = new PriorityQueue<>(Collections.reverseOrder());

        // Step 3: Difference array to apply "range effects" efficiently
        int[] delta = new int[n + 1]; // extra +1 for boundary handling

        int currentDecrements = 0; // number of active decrements at current index
        int queryIndex = 0;        // pointer to process queries in order

        // Step 4: Traverse each index of nums
        for (int i = 0; i < n; i++) {
            // Apply any previous changes (like removing expired queries)
            currentDecrements += delta[i];

            // Add all queries that start at index i
            while (queryIndex < queries.length && queries[queryIndex][0] == i) {
                activeQueries.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            // Use queries if needed to get enough operations for nums[i]
            while (currentDecrements < nums[i] && !activeQueries.isEmpty() && activeQueries.peek() >= i) {
                int end = activeQueries.poll(); // take a query that covers i
                currentDecrements++;           // we apply 1 decrement now
                delta[end + 1]--;              // we'll remove its effect later
            }

            // If we still don’t have enough operations to reduce nums[i] to 0
            if (currentDecrements < nums[i]) {
                return -1; // Not possible to make nums all zero
            }
        }

        // Remaining queries in the heap were not used
        return activeQueries.size();
    }
}
