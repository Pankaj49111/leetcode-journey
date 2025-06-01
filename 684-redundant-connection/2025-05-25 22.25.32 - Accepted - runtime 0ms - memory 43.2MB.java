class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u=edge[0], v=edge[1];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            if(parentU == parentV) return edge;

            parent[parentU] = parentV;
        }
        return new int[0];
    }

    int find(int[] parent, int curr){
        if(parent[curr] != curr){
            parent[curr] = find(parent, parent[curr]);
        }
        return parent[curr];
    }
}