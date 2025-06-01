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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = maxDepth(root);
        return lca(root, maxDepth, 0);
    }

    int maxDepth(TreeNode node){
        if(node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    TreeNode lca(TreeNode node, int maxDepth, int depth){
        if(node == null) return null;
        if(maxDepth - 1 == depth) return node;


        TreeNode left = lca(node.left, maxDepth, depth+1);
        TreeNode right = lca(node.right, maxDepth, depth+1);

        if(left != null && right != null) return node;
        return left != null ? left : right;
    }
}