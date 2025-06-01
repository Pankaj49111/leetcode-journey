class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            int u=time[0];
            int v=time[1];
            int w=time[2];

            // Convert 1-based indexing to 0-based indexing
            adj.get(u-1).add(new int[]{v-1, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE); //infinity
        visited[k-1] = 0; // converting k to 0 based

        pq.add(new int[]{k-1, 0});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[0];
            int t = arr[1];

            for(int[] nbr : adj.get(node)){
                int adjNode = nbr[0];
                int edgeTime = nbr[1];

                if(t + edgeTime < visited[adjNode]){
                    visited[adjNode] = t + edgeTime;
                    pq.add(new int[]{adjNode, visited[adjNode]});
                }
            }
        }

        int maxTime = 0;
        for(int time: visited){
            if(time == Integer.MAX_VALUE) return -1;

            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}