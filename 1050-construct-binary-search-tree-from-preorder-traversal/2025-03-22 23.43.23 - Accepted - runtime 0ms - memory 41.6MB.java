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
    public TreeNode bstFromPreorder(int[] pre) {
        if(pre == null || pre.length == 0) return null;
        
        TreeNode root = new TreeNode(pre[0]);

        for(int i=1; i<pre.length; i++){
            generate(pre[i], root);
        }
        return root;
    }

    void generate(int target, TreeNode node){
        TreeNode root = node;
        TreeNode tnode = new TreeNode(target);
        while(root != null){
            if(target < root.val){
                if(root.left == null){
                    root.left = tnode;
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right == null){
                    root.right = tnode;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
    }
}