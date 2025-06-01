class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);
        
        int result = -1;
        int minMaxDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    result = i;
                } else if (maxDist == minMaxDist && i < result) {
                    result = i;
                }
            }
        }
        
        return result;
    }

    private void bfs(int[] edges, int start, int[] dist) {
        int n = edges.length;
        int currentNode = start;
        int distance = 0;
        
        while (currentNode != -1 && dist[currentNode] == Integer.MAX_VALUE) {
            dist[currentNode] = distance++;
            currentNode = edges[currentNode];
        }
    }
}
