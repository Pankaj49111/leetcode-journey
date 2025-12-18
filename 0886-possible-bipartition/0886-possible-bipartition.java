class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        int[] color = new int[n + 1]; // 0 = uncolored, 1 = A, -1 = B

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int nei : graph[curr]) {
                    if (color[nei] == 0) {
                        color[nei] = -color[curr];
                        q.add(nei);
                    } else if (color[nei] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
