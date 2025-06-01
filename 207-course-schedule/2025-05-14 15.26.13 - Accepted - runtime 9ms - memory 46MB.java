class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] pre : prerequisites){
            graph.computeIfAbsent(pre[1], x -> new ArrayList<>()).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int completed = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            completed++;

            if(graph.containsKey(course)){
                for(int next: graph.get(course)){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        q.offer(next);
                    }
                }
            }
        }
        return completed == numCourses;
    }
}