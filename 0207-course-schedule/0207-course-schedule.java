class Solution {
    public boolean canFinish(int courses, int[][] preq) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indeg = new int[courses];

        for(int i=0; i<courses; i++) graph.add(new ArrayList<>());

        for(int[] p: preq){
            graph.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<courses; i++){
            if(indeg[i] == 0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;

            for(int ng: graph.get(course)){
                indeg[ng]--;
                if(indeg[ng] == 0) q.offer(ng);
            }
        }
        return count == courses;
    }
}