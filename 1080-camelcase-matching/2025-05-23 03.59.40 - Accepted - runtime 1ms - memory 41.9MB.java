class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        TrieNode root = buildPatternTrie(pattern);
        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            result.add(matches(query, root));
        }

        return result;
    }

    // Build a Trie for the pattern
    private TrieNode buildPatternTrie(String pattern) {
        TrieNode root = new TrieNode();
        TrieNode current = root;
        for (char ch : pattern.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEnd = true;
        return root;
    }

    private boolean matches(String query, TrieNode patternTrie) {
        TrieNode current = patternTrie;

        for (char ch : query.toCharArray()) {
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
        }

        return current.isEnd;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
}
