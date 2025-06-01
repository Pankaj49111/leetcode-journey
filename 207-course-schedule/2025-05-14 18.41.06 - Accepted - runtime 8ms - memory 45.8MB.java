class Solution {
    public boolean canFinish(int nums, int[][] preq) {
        int[] indeg = new int[nums];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] pre: preq){
            graph.computeIfAbsent(pre[1], x -> new ArrayList<>()).add(pre[0]);
            indeg[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<nums; i++){
            if(indeg[i]==0) q.offer(i);
        }
        int done = 0;

        while(!q.isEmpty()){
            int course = q.poll();
            done++;

            if(graph.containsKey(course)){
                for(int next: graph.get(course)){
                    indeg[next]--;
                    if(indeg[next] == 0){
                        q.offer(next);
                    }
                }
            }
        }
        return done == nums;
    }
}