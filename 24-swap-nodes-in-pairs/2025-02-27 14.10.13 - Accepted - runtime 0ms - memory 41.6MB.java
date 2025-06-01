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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode res = new ListNode(0, head);
        ListNode prev = res;

        while(head != null && head.next != null){
            ListNode first = head;
            ListNode sec = head.next;

            first.next = sec.next;
            sec.next = first;
            prev.next = sec;
            
            prev = first;
            head = first.next;
        }
        return res.next;
    }
}