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
    class Result {
        int sum;
        int count;
        Result(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }

    int result=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    Result dfs(TreeNode root){
        if(root == null){
            return new Result(0,0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        int sum = root.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;

        if(root.val == (sum/count)) result++;
        return new Result(sum, count);
    }
}