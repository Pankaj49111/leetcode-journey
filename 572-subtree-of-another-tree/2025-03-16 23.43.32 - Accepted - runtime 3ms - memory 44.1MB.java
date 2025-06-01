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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        return divert(root, subRoot);
    }

    boolean divert(TreeNode root, TreeNode subRoot){
        if(root == null) return false;

        if(isSymm(root, subRoot)) return true;

        return divert(root.left, subRoot) || divert(root.right, subRoot);
    }

    boolean isSymm(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;

        if(root == null || subRoot == null) return false;

        return root.val == subRoot.val &&
               isSymm(root.left, subRoot.left) && 
               isSymm(root.right, subRoot.right);
    }
}