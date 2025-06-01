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
    public TreeNode bstToGst(TreeNode root) {
        int[] sum = new int[1];
        helper(root, sum);
        return root;
    }
    void helper(TreeNode node, int[] sum){
        if(node == null) return;

        helper(node.right, sum);

        sum[0] += node.val;
        node.val = sum[0];

        helper(node.left, sum);
    }

}