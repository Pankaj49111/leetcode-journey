/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node temp2 = head;

        Map<Node, Node> map = new HashMap<>();
        while(temp != null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        while(temp2 != null){
            Node newNode = map.get(temp2);
            newNode.next = map.get(temp2.next);
            newNode.random = map.get(temp2.random);
            temp2 = temp2.next;
        }
        return map.get(head);
    }
}