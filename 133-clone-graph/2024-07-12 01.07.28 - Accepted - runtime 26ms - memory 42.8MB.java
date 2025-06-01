/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer,Node> map = new HashMap<>();
        Node copy = clone(map, node);
        return copy;
    }

    Node clone(Map<Integer,Node> map, Node node){
        Node copy = new Node();
        copy.val = node.val;
        map.put(node.val, copy);
        for(int i=0; i<node.neighbors.size(); i++){
            if(!map.containsKey(node.neighbors.get(i).val)){
                clone(map, node.neighbors.get(i));
            }
        }
        for(int i=0; i<node.neighbors.size(); i++){
            copy.neighbors.add(map.get(node.neighbors.get(i).val));
        }
        return copy;
    }
}