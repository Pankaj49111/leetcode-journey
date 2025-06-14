class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            int u = time[0], v = time[1], w = time[2];
            adj.get(u-1).add(new int[]{v-1, w});
        }

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.offer(new int[]{k-1, 0});

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k-1] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0], t = curr[1];

            for(int[] nbr : adj.get(node)){
                int nnode = nbr[0];
                int ntime = nbr[1];

                if(t + ntime < visited[nnode]){
                    visited[nnode] = t+ntime;
                    pq.offer(new int[]{nnode, visited[nnode]});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int vis: visited){
            if(vis == Integer.MAX_VALUE) return -1;

            max = Math.max(max, vis);
        }
        return max;
    }
}