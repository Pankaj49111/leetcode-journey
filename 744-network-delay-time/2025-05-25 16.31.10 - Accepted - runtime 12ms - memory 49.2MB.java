class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adj.get(u - 1).add(new int[]{v - 1, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k - 1] = 0;

        pq.add(new int[]{k - 1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0], edgeTime = neighbor[1];
                if (time + edgeTime < visited[adjNode]) {
                    visited[adjNode] = time + edgeTime;
                    pq.add(new int[]{adjNode, visited[adjNode]});
                }
            }
        }

        int maxTime = 0;
        for (int time : visited) {
            if (time == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }
}
