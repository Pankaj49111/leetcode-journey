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
    public ListNode partition(ListNode head, int x) {
        ListNode lsNode = new ListNode(0);
        ListNode gtNode = new ListNode(0);

        ListNode less = lsNode;
        ListNode gtEq = gtNode;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                gtEq.next = curr;
                gtEq = gtEq.next;
            }
            curr = curr.next;
        }

        gtEq.next = null;
        less.next = gtNode.next;
        return lsNode.next;
    }
}
