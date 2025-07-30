class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;

        // Count of requests each server handled
        int[] count = new int[k];

        // TreeSet to keep track of available servers (sorted)
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) available.add(i);

        // MinHeap to track busy servers: (endTime, serverId)
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            int duration = load[i];

            // Free up servers that have completed their jobs
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] finished = busy.poll();
                available.add(finished[1]);
            }

            if (available.isEmpty()) continue; // Drop request

            // Preferred server
            int preferred = i % k;

            Integer assigned = available.ceiling(preferred);
            if (assigned == null) {
                assigned = available.first(); // wrap around
            }

            // Assign the request
            count[assigned]++;
            available.remove(assigned);
            busy.add(new int[]{time + duration, assigned});
        }

        // Find max count
        int max = Arrays.stream(count).max().getAsInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
