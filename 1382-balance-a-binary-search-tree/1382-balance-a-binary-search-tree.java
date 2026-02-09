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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> ls = new ArrayList<>();
        append(root, ls);
        return convertToBST(ls, 0, ls.size()-1);
    }

    void append(TreeNode node, List<TreeNode> ls){
        if(node == null) return;

        append(node.left, ls);
        ls.add(node);
        append(node.right, ls);
    }

    TreeNode convertToBST(List<TreeNode> ls, int l, int r){
        if(l > r) return null;

        int mid = (l + r)/2;
        TreeNode node = ls.get(mid);

        node.left = convertToBST(ls, l, mid-1);
        node.right = convertToBST(ls, mid+1, r);
        return node;
    }
}