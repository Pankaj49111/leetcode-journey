class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // b → a
        }

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph, visited, result)) return new int[0]; // cycle detected
            }
        }

        Collections.reverse(result); // reverse post-order gives topological sort
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited, List<Integer> result) {
        visited[node] = 1; // mark as visiting

        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 1) return false; // cycle
            if (visited[neighbor] == 0) {
                if (!dfs(neighbor, graph, visited, result)) return false;
            }
        }

        visited[node] = 2; // mark as visited
        result.add(node);  // add after visiting all neighbors
        return true;
    }
}
