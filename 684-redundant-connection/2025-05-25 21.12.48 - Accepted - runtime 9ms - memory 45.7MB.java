class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){
            int u=edge[0], v=edge[1];

            if(graph.containsKey(u) && graph.containsKey(v)){
                if(bfs(u, v, graph)) return edge;
            }
            graph.computeIfAbsent(u, k->new ArrayList()).add(v);
            graph.computeIfAbsent(v, k->new ArrayList()).add(u);
        }
        return new int[0];
    }

    boolean bfs(int u, int v, Map<Integer, List<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(u); visited.add(u);

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == v) return true;

            for(int nbr: graph.getOrDefault(node, new ArrayList<>())){
                if(!visited.contains(nbr)){
                    visited.add(nbr);
                    q.add(nbr);
                }
            }
        }
        return false;
    }
}