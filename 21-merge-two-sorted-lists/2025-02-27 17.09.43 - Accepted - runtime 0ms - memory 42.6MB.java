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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c1 = list1;
        ListNode c2 = list2;

        ListNode res = new ListNode();
        ListNode curr = res;
        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){
                curr.next = c1;
                curr = curr.next;
                c1 = c1.next;
            } else {
                curr.next = c2;
                curr = curr.next;
                c2 = c2.next;
            }
        }
        while(c1 != null){
            curr.next = c1;
            curr = curr.next;
            c1 = c1.next;
        }
        while(c2 != null){
            curr.next = c2;
            curr = curr.next;
            c2 = c2.next;
        }
        return res.next;
    }
}