class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        Map<List<Integer>, Integer> compFreq = new HashMap<>();

        for(int vertex=0; vertex < n; vertex++){
            graph[vertex] = new ArrayList<>();
        }

        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int completeCount = 0;
        Set<Integer> visited = new HashSet<>();

        for(int vrtx=0; vrtx<n; vrtx++){
            if(visited.contains(vrtx)) continue;
            
            int[] compInfo = new int[2];
            dfs(vrtx, graph, visited, compInfo);

            if(compInfo[0]*(compInfo[0]-1) == compInfo[1]){
                completeCount++;
            }
        }
        return completeCount;
    }

    void dfs(int curr, List<Integer>[] graph, Set<Integer> visited, int[] compInfo){
        visited.add(curr);

        compInfo[0]++;
        compInfo[1] += graph[curr].size();

        for(int next: graph[curr]){
            if(!visited.contains(next)){
                dfs(next, graph, visited, compInfo);
            }
        }

    }

}