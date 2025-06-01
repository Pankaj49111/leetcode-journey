class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();

        // Build the trie with the dictionary
        for (String word : dict) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
            }
            current.isEnd = true;
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (result.length() > 0) result.append(" ");
            result.append(getShortestRoot(word, root));
        }

        return result.toString();
    }

    private String getShortestRoot(String word, TrieNode root) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch) || current.isEnd) break;
            current = current.children.get(ch);
            prefix.append(ch);
        }
        return current.isEnd ? prefix.toString() : word;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
}
