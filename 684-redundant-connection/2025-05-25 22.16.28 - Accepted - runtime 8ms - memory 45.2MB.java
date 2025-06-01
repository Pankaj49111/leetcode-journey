class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){
            int u=edge[0], v=edge[1];

            if(graph.containsKey(u) && graph.containsKey(v)){
                Set<Integer> visited = new HashSet<>();

                if(dfs(u, v, graph, visited)) return edge;
            }
            graph.computeIfAbsent(u, k->new ArrayList()).add(v);
            graph.computeIfAbsent(v, k->new ArrayList()).add(u);
        }
        return new int[0];
    }

    boolean dfs(int u, int v, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        if(u == v) return true;
        visited.add(u);

        for(int nbr: graph.getOrDefault(u, new ArrayList<>())){
            if(!visited.contains(nbr)){
                if(dfs(nbr, v, graph, visited)) return true;
            }
        }
        return false;
    }
}