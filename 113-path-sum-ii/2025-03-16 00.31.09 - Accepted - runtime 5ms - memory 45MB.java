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
        process(root, ls, res);
        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> li: res){
            int sum = li.stream().mapToInt(a->a).sum();
            if(sum == targetSum) ans.add(li);
        }
        return ans;
    }

    void process(TreeNode root, List<Integer> ls, List<List<Integer>> res) {
        if(root == null) return;
        
        ls.add(root.val);

        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(ls));
        }
        
        process(root.left, ls, res);
        process(root.right, ls, res);

        ls.remove(ls.size()-1);
    }
}