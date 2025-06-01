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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        TreeNode pt=root.left;
        TreeNode pt2=root.right;
        return symm(pt, pt2);
    }

    boolean symm(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;

        if(r1 == null || r2 == null) return false;

        return r1.val == r2.val && 
        symm(r1.left, r2.right) && symm(r1.right, r2.left);
    }
}