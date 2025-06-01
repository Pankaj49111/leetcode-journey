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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode front = dummy;

        while(front != null){
            ListNode end = front.next;
            int prefixSum = 0;
            while(end != null){
                prefixSum += end.val;

                if(prefixSum == 0){
                    front.next = end.next;
                }
                end = end.next;
            }
            front = front.next;
        }
        return dummy.next;
    }
}