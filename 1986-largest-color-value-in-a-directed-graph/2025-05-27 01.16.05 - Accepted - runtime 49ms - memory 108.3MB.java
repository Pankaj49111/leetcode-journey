class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[][] count = new int[n][26];

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegr = new int[n];

        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            indegr[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegr[i] == 0) q.offer(i);
        }

        int processed = 0, maxColorVal = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            processed++;

            int colorIdx = colors.charAt(node) - 'a';
            count[node][colorIdx]++;
            maxColorVal = Math.max(maxColorVal, count[node][colorIdx]);

            for(int nbr: graph.get(node)){

                for(int c=0; c<26; c++){
                    count[nbr][c] = Math.max(count[nbr][c], count[node][c]);
                }
                indegr[nbr]--;
                if(indegr[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        return processed == n ? maxColorVal : -1;
    }
}