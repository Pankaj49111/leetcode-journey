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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean evenLevel = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int val = node.val;

                if (evenLevel && (val % 2 == 0)) return false;
                if (!evenLevel && (val % 2 != 0)) return false; 

                if (evenLevel && val <= prev) return false;
                if (!evenLevel && val >= prev) return false;

                prev = val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            evenLevel = !evenLevel;
        }

        return true;
    }
}
