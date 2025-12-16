class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent = new int[n+1];

        for(int i=1; i<=n; i++) parent[i] = i;

        for(int[] e: edges){
            int u = e[0], v = e[1];

            if(find(u) == find(v)) return e;

            union(u, v);
        }
        return new int[0];
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int px = parent[x];
        int py = parent[y];

        if(px != py) parent[py] = px;
    }
}