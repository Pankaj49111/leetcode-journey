class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(res, path, graph, 0);
        return res;
    }

    void backtrack(List<List<Integer>> res, List<Integer> path, int[][] graph, int curr){
        if(curr == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int neigh: graph[curr]){
            path.add(neigh);
            backtrack(res, path, graph, neigh);
            path.remove(path.size()-1);
        }
    }
}