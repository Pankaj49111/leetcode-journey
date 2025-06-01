class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode res = new ListNode(0);
        res.next = head;

        ListNode ans = res;
        for (int i = 1; i < left; i++) {
            ans = ans.next;
        }

        ListNode curr = ans.next;
        ListNode prev = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ans.next.next = curr;
        ans.next = prev;

        return res.next;
    }
}
