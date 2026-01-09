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
    private int maxDepth = 0;
    private TreeNode answer = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return answer;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) return depth - 1;

        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);

        int currentMax = Math.max(leftDepth, rightDepth);

        if (leftDepth == rightDepth && currentMax >= maxDepth) {
            maxDepth = currentMax;
            answer = node;
        }

        return currentMax;
    }
}
