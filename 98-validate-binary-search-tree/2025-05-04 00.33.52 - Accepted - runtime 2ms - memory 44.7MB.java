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
    public boolean isValidBST(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        store(root, ls);
        for(int i=1; i<ls.size(); i++){
            if(ls.get(i-1) >= ls.get(i)) return false;
        }
        return true;
    }

    void store(TreeNode node, List<Integer> ls){
        if(node == null) return;

        store(node.left, ls);
        ls.add(node.val);
        store(node.right, ls);
    }
}