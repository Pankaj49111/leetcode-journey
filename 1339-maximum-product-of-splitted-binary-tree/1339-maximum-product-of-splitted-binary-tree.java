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
    long totalSum;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = computeSums(root);

        for (long s : subtreeSums) {
            long product = s * (totalSum - s);
            maxProduct = Math.max(maxProduct, product);
        }

        return (int)(maxProduct % MOD);
    }

    List<Long> subtreeSums = new ArrayList<>();

    long computeSums(TreeNode node) {
        if (node == null) return 0;

        long sum = node.val
                 + computeSums(node.left)
                 + computeSums(node.right);

        subtreeSums.add(sum);
        return sum;
    }
}
