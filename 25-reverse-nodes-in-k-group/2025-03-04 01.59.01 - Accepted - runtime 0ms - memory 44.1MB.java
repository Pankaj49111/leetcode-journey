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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while(temp != null && count < k){
            temp = temp.next;
            count++;
        }

        if(count < k) return head;

        ListNode newHead = reverse(head, temp);
        head.next = reverseKGroup(temp, k);
        return newHead;
    }

    ListNode reverse(ListNode head, ListNode end){
        ListNode curr = head, prev = null;

        while(curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}