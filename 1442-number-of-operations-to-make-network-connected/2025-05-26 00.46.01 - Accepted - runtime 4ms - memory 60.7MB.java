class Solution {
    class UnionFind{
        int[] parent;
        int count;

        UnionFind(int n){
            parent = new int[n];
            count = n;
            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y){
            int parentU = find(x);
            int parentV = find(y);

            if(parentU != parentV){
                parent[parentV] = parentU;
                count--;
                return true;
            }
            return false;
        }

        int getCount(){
            return count;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        UnionFind uf = new UnionFind(n);
        for(int[] conn: connections){
            uf.union(conn[0], conn[1]);
        }

        return uf.getCount() - 1;
    }
}