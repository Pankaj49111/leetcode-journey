/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int pos=-1, i=0;
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode curr=head;
        while(curr != null && curr.next != null) {
            if(map.containsKey(curr)) {
                return curr;
            } else {
                map.put(curr, i);
                i++;
                curr = curr.next;
            }
        }
        return null;
    }
}