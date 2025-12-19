class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] hasSecret = new boolean[n];
        hasSecret[0] = true;
        hasSecret[firstPerson] = true;

        UnionFind uf = new UnionFind(n);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> sameTime = new ArrayList<>();

            // collect all meetings at same time
            while (i < meetings.length && meetings[i][2] == time) {
                sameTime.add(meetings[i]);
                i++;
            }

            // union all pairs at this time
            for (int[] m : sameTime) {
                uf.union(m[0], m[1]);
            }

            // check which components get the secret
            Map<Integer, Boolean> componentHasSecret = new HashMap<>();
            for (int[] m : sameTime) {
                int px = uf.find(m[0]);
                if (hasSecret[m[0]] || hasSecret[m[1]]) {
                    componentHasSecret.put(px, true);
                }
            }

            // spread secret inside components
            for (int[] m : sameTime) {
                int x = m[0], y = m[1];
                if (componentHasSecret.getOrDefault(uf.find(x), false)) {
                    hasSecret[x] = true;
                    hasSecret[y] = true;
                }
            }

            // reset union-find for next time
            for (int[] m : sameTime) {
                uf.reset(m[0]);
                uf.reset(m[1]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (hasSecret[p]) res.add(p);
        }
        return res;
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) parent[pb] = pa;
        }

        void reset(int x) {
            parent[x] = x;
        }
    }
}
