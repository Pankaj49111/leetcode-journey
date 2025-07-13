class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }
        // Priority queue to get the task with highest remaining count
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(taskCounts.values());

        int time = 0;

        // Queue to keep track of cooldowns [count, readyTime]
        Queue<int[]> cooldown = new LinkedList<>();

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int count = pq.poll() - 1;
                if (count > 0) {
                    cooldown.add(new int[]{count, time + n});
                }
            }

            // Check if any task is ready to come out of cooldown
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                pq.add(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
