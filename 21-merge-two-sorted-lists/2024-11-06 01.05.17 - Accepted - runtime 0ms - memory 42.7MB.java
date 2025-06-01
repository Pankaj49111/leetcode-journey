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
        ListNode head = new ListNode(0);
        ListNode response = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val) {
                response.next = list1;
                list1 = list1.next;
            } else {
                response.next = list2;
                list2 = list2.next;
            }
            response = response.next;
        }
        if(list1 != null) response.next = list1;
        if(list2 != null) response.next = list2;

        return head.next;
    }
}