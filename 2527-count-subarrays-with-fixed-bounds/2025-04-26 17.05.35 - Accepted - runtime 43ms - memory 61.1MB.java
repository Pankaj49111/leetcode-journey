class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int n = nums.length;
        
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        
        int left = 0;
        for (int i = 0; i < n; i++) {
            // If the current element is out of range, reset the window
            if (nums[i] < minK || nums[i] > maxK) {
                minQueue.clear();
                maxQueue.clear();
                left = i + 1;  // Set the start of the next valid subarray window
                continue;
            }
            
            // Maintain the minQueue (increasing order)
            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[i]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(i);
            
            // Maintain the maxQueue (decreasing order)
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(i);
            
            if(nums[minQueue.peekFirst()] == minK && nums[maxQueue.peekFirst()] == maxK){
                int start = Math.min(minQueue.peekFirst(), maxQueue.peekFirst());
                // Count the valid subarrays
                count += (start - left + 1);
            }
        }
        return count;
    }
}
