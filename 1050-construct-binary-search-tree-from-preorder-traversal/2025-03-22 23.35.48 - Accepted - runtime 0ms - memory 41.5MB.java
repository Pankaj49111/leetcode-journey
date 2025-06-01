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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null) return null;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode helper(int[] pre, int l, int r){
        if(idx == pre.length || pre[idx] < l || pre[idx] > r)
            return null;

        int val = pre[idx++];
        TreeNode node = new TreeNode(val);
        node.left = helper(pre, l, val);
        node.right = helper(pre, val, r);
        return node;
    }
}