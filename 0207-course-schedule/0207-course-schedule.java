class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[numCourses];

        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());

        for(int[] pre: prereq){
            graph.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDeg[i] == 0) q.offer(i);
        }

        int count=0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;

            for(int neigh: graph.get(course)){
                inDeg[neigh]--;

                if(inDeg[neigh] == 0) q.offer(neigh);
            }
        }
        return count == numCourses;
    }
}