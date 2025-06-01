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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode tmp = head;
        int length = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head; 
        }

        ListNode slow = head;
        for (int i = 1; i < length - k; i++) {
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        tmp.next = head;

        return newHead;
    }
}
