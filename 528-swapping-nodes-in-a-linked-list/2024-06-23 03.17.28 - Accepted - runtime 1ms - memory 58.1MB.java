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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode back = head;
        ListNode fast = head;

        for(int i=0; i<k-1; i++){
            fast = fast.next;
        }
        ListNode front = fast;

        while(fast.next != null){
            back = back.next;
            fast = fast.next;
        }

        int temp = front.val;
        front.val = back.val;
        back.val = temp;

        return head;
    }
}