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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        process(root, targetSum, ls, res);
        return res;
    }

    void process(TreeNode root, int target, List<Integer> ls, 
                    List<List<Integer>> res) {
        if(root == null) return;
        
        ls.add(root.val);

        if(root.left == null && root.right == null && target == root.val){
            res.add(new ArrayList<>(ls));
        }
        
        process(root.left, target-root.val, ls, res);
        process(root.right, target-root.val, ls, res);

        // back-tracking
        ls.remove(ls.size()-1);
    }
}