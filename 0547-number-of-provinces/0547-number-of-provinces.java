class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConn) {
        int n=isConn.length;
        parent = new int[n];

        for(int i=0; i<n; i++) parent[i] = i;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isConn[i][j] == 1) union(i,j);
            }
        }

        int prov=0;
        for(int i=0; i<n; i++){
            if(parent[i] == i) prov++;
        }
        return prov;
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py) parent[py] = px;
    }
}