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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        return helper(lists, 0, lists.length-1);
    }

    ListNode helper(ListNode[] ls, int start, int end){
        if(start == end) return ls[start];

        int mid = start + (end - start)/2;
        ListNode l1 = helper(ls, start, mid);
        ListNode l2 = helper(ls, mid+1, end);
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode curr = res;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while(l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while(l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return res.next;
    }
}