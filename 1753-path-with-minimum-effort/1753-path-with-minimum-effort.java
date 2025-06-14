class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int total = rows * cols;

        // Build edge list: [weight, node1, node2]
        List<int[]> edges = new ArrayList<>();

        int[][] directions = {{0, 1}, {1, 0}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int index = r * cols + c;
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < rows && nc < cols) {
                        int nIndex = nr * cols + nc;
                        int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                        edges.add(new int[]{diff, index, nIndex});
                    }
                }
            }
        }

        // Sort edges by effort (weight)
        Collections.sort(edges, Comparator.comparingInt(a -> a[0]));

        DSU dsu = new DSU(total);

        for (int[] edge : edges) {
            int weight = edge[0];
            int u = edge[1], v = edge[2];
            dsu.union(u, v);

            if (dsu.find(0) == dsu.find(total - 1)) {
                return weight;
            }
        }

        return 0;
    }

    static class DSU {
        int[] parent, rank;

        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
