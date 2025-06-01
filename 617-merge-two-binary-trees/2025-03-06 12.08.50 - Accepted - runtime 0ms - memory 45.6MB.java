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
    public TreeNode mergeTrees(TreeNode r1, TreeNode r2) {
        TreeNode root = new TreeNode();
        if(r1 == null) return r2;
        if(r2 == null) return r1;

        root.val = r1.val + r2.val;
        root.left = mergeTrees(r1.left, r2.left);
        root.right = mergeTrees(r1.right, r2.right);
        return root;
    }
}