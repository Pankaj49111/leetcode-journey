class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(source);
        visited.add(source);
        
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == dest) return true;
            
            for(int neigh: graph.getOrDefault(node, new ArrayList<>())){
                if(!visited.contains(neigh)){
                    visited.add(neigh);
                    q.offer(neigh);
                }
            }
        }
        return false;
    }
}