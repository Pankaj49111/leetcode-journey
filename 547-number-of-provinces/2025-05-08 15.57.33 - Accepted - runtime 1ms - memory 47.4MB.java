class Solution {
    class DSU{
        int[] parent;
        int components;
        public DSU(int n){
            parent = new int[n];
            components = n;
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]!=x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x,int y){
            int r1 = find(x);
            int r2 = find(y);
            if(r1!=r2){
                parent[r2] = r1;
                components--;
            } 
            
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }
        return dsu.components;
    }
}