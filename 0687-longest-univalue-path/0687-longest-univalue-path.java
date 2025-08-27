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
    public int longestUnivaluePath(TreeNode root) {
        // Variable to keep track of the longest path
        int[] maxLength = new int[1]; // maxLength[0] will store the result

        // Helper function to perform DFS
        dfs(root, maxLength);

        return maxLength[0];
    }

    // Helper function for DFS traversal
    int dfs(TreeNode node, int[] maxLength) {
        if (node == null) return 0;

        // Recursively calculate the path length in left and right subtrees
        int leftLength = dfs(node.left, maxLength);
        int rightLength = dfs(node.right, maxLength);

        // Variables to store the longest path going through the current node
        int leftPath = 0, rightPath = 0;

        // If the left child has the same value, we extend the path from left
        if (node.left != null && node.left.val == node.val) {
            leftPath = leftLength + 1;
        }

        // If the right child has the same value, we extend the path from right
        if (node.right != null && node.right.val == node.val) {
            rightPath = rightLength + 1;
        }

        // Update the global maximum length
        maxLength[0] = Math.max(maxLength[0], leftPath + rightPath);

        // Return the length of the longest single path going down the current node
        return Math.max(leftPath, rightPath);
    }
}
