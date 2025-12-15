class Solution {
    public int findCircleNum(int[][] isConn) {
        int n=isConn.length;
        boolean[] vis=new boolean[n];
        int prov=0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(isConn, vis, i);
                prov++;
            }
        }
        return prov;
    }

    void dfs(int[][] graph, boolean[] vis, int idx){
        vis[idx] = true;
        for(int j=0; j<graph.length; j++){
            if(graph[idx][j] == 1 && !vis[j]){
                dfs(graph, vis, j);
            }
        }
    }
}