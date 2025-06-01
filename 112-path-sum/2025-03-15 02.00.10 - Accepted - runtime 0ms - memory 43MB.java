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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        List<Integer> ls = new ArrayList<>();
        dfs(root, sum, ls);
        // System.out.println(ls);
        return ls.contains(targetSum);
    }

    void dfs(TreeNode root, int sum, List<Integer> ls){
        if(root == null) return;

        sum += root.val;
        if(root.left == null && root.right == null){
            ls.add(sum);
        }
        dfs(root.left, sum, ls);
        dfs(root.right, sum, ls);
    }
}