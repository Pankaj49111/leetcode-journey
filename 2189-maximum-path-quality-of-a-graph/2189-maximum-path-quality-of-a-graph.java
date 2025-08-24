class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;

        // Build graph: node -> List of [neighbor, time]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        boolean[] visited = new boolean[n];
        int[] maxQuality = new int[1];

        dfs(0, 0, 0, values, visited, graph, maxTime, maxQuality);

        return maxQuality[0];
    }

    void dfs(int node, int time, int quality, int[] values, boolean[] visited,
                    Map<Integer, List<int[]>> graph, int maxTime, int[] maxQuality) {

        boolean firstVisit = !visited[node];
        if (firstVisit) {
            visited[node] = true;
            quality += values[node];
        }

        // If we return to node 0 and within time limit, update max
        if (node == 0) {
            maxQuality[0] = Math.max(maxQuality[0], quality);
        }

        for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            int nextNode = neighbor[0], travelTime = neighbor[1];
            if (time + travelTime <= maxTime) {
                dfs(nextNode, time + travelTime, quality, values, visited, graph, maxTime, maxQuality);
            }
        }

        if (firstVisit) {
            visited[node] = false; // backtrack
        }
    }
}