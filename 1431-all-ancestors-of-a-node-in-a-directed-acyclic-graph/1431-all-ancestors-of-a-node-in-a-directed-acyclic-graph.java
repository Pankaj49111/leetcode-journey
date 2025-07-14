class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge: edges){
            graph.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            Set<Integer> ancs = new HashSet<>();
            dfs(graph, i, ancs);
            List<Integer> ls = new ArrayList<>(ancs);
            Collections.sort(ls);
            res.add(ls);
        }
        return res;
    }

    void dfs(List<List<Integer>> graph, int idx, Set<Integer> ancs){
        for(int prev: graph.get(idx)){
            if(ancs.add(prev)) dfs(graph, prev, ancs);
        }
    }
}