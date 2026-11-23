class Solution {
    public int[] findOrder(int n, int[][] preq) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indeg = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] p : preq) {
            graph.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int[] ans = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int c = q.poll();
            ans[idx++] = c;

            for (int ng : graph.get(c)) {
                indeg[ng]--;

                if (indeg[ng] == 0)
                    q.offer(ng);
            }
        }

        return idx == n ? ans : new int[]{};
    }
}