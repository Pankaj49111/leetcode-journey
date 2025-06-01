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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode res = new ListNode();
        ListNode curr = res;

        int carry = 0;

        while(c1 != null || c2 != null){
            int total = 0;
            if(c1 != null){
                total += c1.val;
                c1 = c1.next;
            }
            if(c2 != null){
                total += c2.val;
                c2 = c2.next;
            }

            total += carry;
            int add = total % 10;
            curr.next = new ListNode(add);
            curr = curr.next;
            carry = total / 10;
        }
        if(carry != 0) curr.next = new ListNode(carry);
        return res.next;
    }
}