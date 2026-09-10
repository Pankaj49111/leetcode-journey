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
        int root;
        int sum;
        int count;
        Result(int root, int sum, int count){
            this.root = root;
            this.sum = sum;
            this.count = count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }

        List<Result> res = new ArrayList<>();
        dfs(root, res);

        int cnt=0;

        for(Result r: res){
            if(r.root == (r.sum / r.count)) cnt++;
        }
        return cnt;
    }

    Result dfs(TreeNode root, List<Result> res){
        if(root == null){
            return new Result(0,0,0);
        }

        Result left = dfs(root.left, res);
        Result right = dfs(root.right, res);

        int sum = root.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;
        Result response = new Result(root.val, sum,count);
        res.add(response);
        return response;
    }
}