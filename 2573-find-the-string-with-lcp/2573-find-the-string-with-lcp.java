class Solution {
    int[] parent;

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        // Step 2: DSU init
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Step 3: union
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(i, j);
                }
            }
        }

        // Step 4: assign chars
        char[] word = new char[n];
        char ch = 'a';

        int[] groupChar = new int[n];
        Arrays.fill(groupChar, -1);

        for (int i = 0; i < n; i++) {
            int p = find(i);
            if (groupChar[p] == -1) {
                if (ch > 'z') return "";
                groupChar[p] = ch++;
            }
            word[i] = (char) groupChar[p];
        }

        // Step 5: verify by recomputing LCP
        int[][] calc = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    calc[i][j] = 1;
                    if (i + 1 < n && j + 1 < n) {
                        calc[i][j] += calc[i + 1][j + 1];
                    }
                }
            }
        }

        // compare
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(calc[i], lcp[i])) return "";
        }

        return new String(word);
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}