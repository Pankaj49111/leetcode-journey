class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();
        int[] outdeg = new int[n];

        for(int i=0; i<n; i++){
            revGraph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            outdeg[i] = graph[i].length;
            for(int j: graph[i]){
                revGraph.get(j).add(i); // reversing edges
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(outdeg[i] == 0) q.offer(i);
        }

        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;

            for(int neigh: revGraph.get(node)){
                outdeg[neigh]--;
                if(outdeg[neigh] == 0) q.offer(neigh);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}