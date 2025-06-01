class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> dist1 = getDistance(edges, node1);
        Map<Integer, Integer> dist2 = getDistance(edges, node2);

        int res = -1, minMaxDist = Integer.MAX_VALUE;

        for(int i=0; i<edges.length; i++){
            if(dist1.containsKey(i) && dist2.containsKey(i)){
                int maxDist = Math.max(dist1.get(i), dist2.get(i));

                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    res = i;
                } else if (maxDist == minMaxDist && i < res) {
                    res = i;
                }
            }
        }
        return res;
    }

    Map<Integer, Integer> getDistance(int[] edges, int node){
        Map<Integer, Integer> dist = new HashMap<>();
        int distance = 0;

        while(node != -1 && !dist.containsKey(node)){
            dist.put(node, distance++);
            node = edges[node];
        }
        return dist;
    }
}