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
class NodeVal {
    int maxval, minval, maxsum;
    NodeVal(int maxval, int minval, int maxsum) {
        this.maxval = maxval;
        this.minval = minval;
        this.maxsum = maxsum;
    }
}

class Solution {
    private NodeVal maxSubtree(TreeNode root, int[] ans) {
        if (root == null) return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeVal left = maxSubtree(root.left, ans);
        NodeVal right = maxSubtree(root.right, ans);

        if (left.maxval < root.val && root.val < right.minval) {
            int currSum = left.maxsum + right.maxsum + root.val;
            ans[0] = Math.max(ans[0], currSum);
            return new NodeVal(Math.max(right.maxval, root.val), Math.min(left.minval, root.val), currSum);
        }

        return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxsum, right.maxsum));
    }

    public int maxSumBST(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        maxSubtree(root, ans);
        return Math.max(ans[0], 0);
    }
}