class Solution {
    class DSU {
        int[] parent;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]); // Path compression
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                // Always attach the larger index to the smaller to ensure lex min
                if (px < py) {
                    parent[py] = px;
                } else {
                    parent[px] = py;
                }
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU(26); // Only lowercase English letters

        // Union characters from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            dsu.union(c1, c2);
        }

        // Build the smallest equivalent string
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int root = dsu.find(ch - 'a');
            result.append((char)(root + 'a'));
        }

        return result.toString();
    }
}
