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
    public ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode res = new ListNode();
        ListNode curr = res;

        int carry = 0;
        while(r1 != null || r2 != null || carry != 0){
            int total = carry;
            if(r1 != null){
                total += r1.val;
                r1 = r1.next;
            }
            if(r2 != null){
                total += r2.val;
                r2 = r2.next;
            }
            int num = total % 10;
            curr.next = new ListNode(num);
            curr = curr.next;
            carry = total/10;
        }
        return reverse(res.next);
    }
}