class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[10];
        boolean isEnd = false;
    }

    private void insert(TrieNode root, int num) {
        String s = Integer.toString(num);
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    // DFS traversal of the Trie
    private void dfs(TrieNode node, String path, List<Integer> result) {
        if (node.isEnd) {
            result.add(Integer.parseInt(path));
        }

        for (int i = 0; i <= 9; i++) {
            if (node.children[i] != null) {
                dfs(node.children[i], path + i, result);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        TrieNode root = new TrieNode();
        for (int i = 1; i <= n; i++) {
            insert(root, i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (root.children[i] != null) {
                dfs(root.children[i], "" + i, result);
            }
        }

        return result;
    }
}
