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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        while(head != null) {
            ls.add(head.val);
            head = head.next;
        }
        return bst(ls, 0, ls.size()-1);
    }

    TreeNode bst(List<Integer> ls, int l, int r){
        if(l>r) return null;

        int mid = l + (r-l)/2;

        TreeNode node = new TreeNode(ls.get(mid));

        node.left = bst(ls, l, mid-1);
        node.right = bst(ls, mid+1, r);
        return node;
    }
}