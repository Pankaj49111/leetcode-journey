class Solution {
    int[] parent;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : connections) {
            union(edge[0], edge[1]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                components++;
            }
        }

        return components - 1;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[py] = px;
        }
    }
}
