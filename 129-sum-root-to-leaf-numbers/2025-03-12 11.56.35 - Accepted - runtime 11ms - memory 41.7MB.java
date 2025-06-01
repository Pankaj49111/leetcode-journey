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
    public int sumNumbers(TreeNode root) {
        List<String> ls = new ArrayList<>();
        process(root, ls, "");
        return ls.stream().mapToInt(Integer::parseInt).sum();
    }

    void process(TreeNode node, List<String> ls, String path){
        if(node == null) return;
        path += node.val;

        if(node.left == null && node.right == null){
            ls.add(path);
        }

        process(node.left, ls, path); 
        process(node.right, ls, path);
    }
}