class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Build graph and indegree
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int taken = 0; // count of courses we can take
        while (!queue.isEmpty()) {
            int course = queue.poll();
            taken++;

            for (int nei : graph.get(course)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return taken == numCourses;
    }
}
