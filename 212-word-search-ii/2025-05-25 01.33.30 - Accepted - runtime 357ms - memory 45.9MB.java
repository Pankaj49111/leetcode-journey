class Solution {
    class Node{
        Map<Character, Node> child = new HashMap<>();
        String word = null;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Node root = createTrie(words);

        int r=board.length, c=board[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    void dfs(char[][] board, int i, int j, Node node, List<String> result){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if(c == '#' || !node.child.containsKey(c)) return;

        Node next = node.child.get(c);
        if(next.word != null){
            result.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';

        dfs(board, i+1, j, next, result);
        dfs(board, i-1, j, next, result);
        dfs(board, i, j+1, next, result);
        dfs(board, i, j-1, next, result);

        board[i][j] = c;
    }

    Node createTrie(String[] words){
        Node root = new Node();

        for(String word: words){
            Node node = root;
            for(char c: word.toCharArray()){
                node.child.putIfAbsent(c, new Node());
                node = node.child.get(c);
            }
            node.word = word;
        }
        return root;
    }
}