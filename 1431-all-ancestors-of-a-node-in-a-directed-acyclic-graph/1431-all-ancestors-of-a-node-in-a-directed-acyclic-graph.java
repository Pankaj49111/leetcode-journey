class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Each node will have a set of ancestors
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) ancestors.add(new HashSet<>());

        // Topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                // Add all ancestors of node into neighbor
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));

                // Decrease indegree and enqueue if 0
                if (--indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Convert sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : ancestors) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }
}