class Solution {
    class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adj.get(u - 1).add(new Pair(v - 1, w)); // convert to 0-based index
        }

        // Min-heap based on time
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k - 1] = 0;

        pq.add(new Pair(k - 1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int time = curr.time;

            for (Pair neighbor : adj.get(node)) {
                int next = neighbor.node;
                int travelTime = neighbor.time;

                if (time + travelTime < visited[next]) {
                    visited[next] = time + travelTime;
                    pq.add(new Pair(next, visited[next]));
                }
            }
        }

        int maxTime = 0;
        for (int t : visited) {
            if (t == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, t);
        }

        return maxTime;
    }
}
