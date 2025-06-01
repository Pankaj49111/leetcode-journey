class Solution {
    public int[] findOrder(int nums, int[][] preq) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indeg = new int[nums];

        for(int i=0; i<nums; i++) graph.add(new ArrayList<>());

        for(int[] pre: preq){
            graph.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<nums; i++) {
            if(indeg[i] == 0) q.offer(i);
        }

        int[] order = new int[nums];
        int idx = 0;
        
        while(!q.isEmpty()){
            int course = q.poll();
            order[idx++] = course;

            for(int neigh : graph.get(course)){
                indeg[neigh]--;
                if(indeg[neigh] == 0) q.add(neigh);
            }
        }
        return idx == nums ? order : new int[0];
    }
}