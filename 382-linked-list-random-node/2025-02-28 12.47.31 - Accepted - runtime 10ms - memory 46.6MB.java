/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode curr = null;
    int count = 0;
    public Solution(ListNode head) {
        curr = head;
        while(curr!=null){
            this.count++;
            curr = curr.next;
        }
        curr = head;
    }
    
    public int getRandom() {
        int rand = (int)(Math.random() * this.count);
        ListNode node = curr;
        while(rand-- > 0){
            node = node.next;
        }
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */