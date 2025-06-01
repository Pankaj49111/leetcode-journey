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
        List<ListNode> less = new ArrayList<>();
        List<ListNode> greaterOrEqual = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                less.add(curr);
            } else {
                greaterOrEqual.add(curr);
            }
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : less) {
            tail.next = node;
            tail = node;
        }

        for (ListNode node : greaterOrEqual) {
            tail.next = node;
            tail = node;
        }

        tail.next = null;
        return dummy.next;
    }
}
