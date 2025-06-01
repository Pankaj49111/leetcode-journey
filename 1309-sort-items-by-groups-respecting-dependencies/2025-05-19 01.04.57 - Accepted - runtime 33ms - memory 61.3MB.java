public class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Assign unique group IDs to items with group[i] == -1
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId++;
            }
        }

        // Group to items map
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groupToItems.computeIfAbsent(group[i], k -> new ArrayList<>()).add(i);
        }

        // Build graphs
        List<List<Integer>> itemGraph = new ArrayList<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());

        List<List<Integer>> groupGraph = new ArrayList<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; i++) groupGraph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int before : beforeItems.get(i)) {
                itemGraph.get(before).add(i);
                itemIndegree[i]++;
                if (group[i] != group[before]) {
                    groupGraph.get(group[before]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        // Topological sort for groups
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree, groupId);
        if (groupOrder == null) return new int[0];

        // Topological sort for items within each group
        List<Integer> result = new ArrayList<>();
        for (int g : groupOrder) {
            List<Integer> items = groupToItems.getOrDefault(g, new ArrayList<>());
            if (items.isEmpty()) continue;

            // Build subgraph for items in this group
            List<List<Integer>> subGraph = new ArrayList<>();
            Map<Integer, Integer> indexMap = new HashMap<>();
            int idx = 0;
            for (int item : items) {
                indexMap.put(item, idx++);
                subGraph.add(new ArrayList<>());
            }

            int[] subIndegree = new int[items.size()];
            for (int item : items) {
                for (int neighbor : itemGraph.get(item)) {
                    if (group[neighbor] == g) {
                        subGraph.get(indexMap.get(item)).add(indexMap.get(neighbor));
                        subIndegree[indexMap.get(neighbor)]++;
                    }
                }
            }

            List<Integer> sortedGroupItems = topoSort(subGraph, subIndegree, items.size());
            if (sortedGroupItems == null) return new int[0];
            for (int i : sortedGroupItems) result.add(items.get(i));
        }

        // Convert result to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    // Generic topological sort
    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree, int totalNodes) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < totalNodes; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);
            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return order.size() == totalNodes ? order : null;
    }
}
