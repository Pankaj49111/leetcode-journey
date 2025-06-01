class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        Map<List<Integer>, Integer> compFreq = new HashMap<>();

        for(int vertex=0; vertex < n; vertex++){
            graph[vertex] = new ArrayList<>();
            graph[vertex].add(vertex);
        }

        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for(int vrtx=0; vrtx<n; vrtx++){
            List<Integer> neighbours = graph[vrtx];
            Collections.sort(neighbours);
            compFreq.put(neighbours, compFreq.getOrDefault(neighbours,0)+1);
        }

        // int completeCount = 0;
        // for(Map.Entry<List<Integer>, Integer> entry: compFreq.entrySet()){
        //     if(entry.getKey().size() == entry.getValue()){
        //         completeCount++;
        //     }
        // }
        // return completeCount;
        return (int)compFreq.entrySet().stream()
            .filter(e -> e.getKey().size() == e.getValue()).count();
    }
}