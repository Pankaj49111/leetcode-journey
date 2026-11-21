class Solution {
    List<Integer>[] tree;
    List<Integer>[] newTree;

    int[] last = new int[26];
    int[] newParent;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        tree = new ArrayList[n];
        newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        Arrays.fill(last, -1);
        newParent = parent.clone();

        // Find new parents
        findParents(0, s);

        // Build modified tree
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        int[] ans = new int[n];
        calculateSize(0, ans);

        return ans;
    }

    private void findParents(int node, String s) {
        int ch = s.charAt(node) - 'a';
        int previous = last[ch];

        if (previous != -1) {
            newParent[node] = previous;
        }
        last[ch] = node;

        for (int child : tree[node]) {
            findParents(child, s);
        }
        // Backtrack
        last[ch] = previous;
    }

    private int calculateSize(int node, int[] ans) {
        int size = 1;

        for (int child : newTree[node]) {
            size += calculateSize(child, ans);
        }
        ans[node] = size;
        return size;
    }
}
