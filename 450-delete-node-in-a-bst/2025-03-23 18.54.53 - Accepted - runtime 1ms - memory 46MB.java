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
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer> ls = new ArrayList<>();
        inorder(root, key, ls);

        return bst(ls, 0, ls.size()-1);
    }

    void inorder(TreeNode root, int key, List<Integer> ls){
        if(root == null) return;

        inorder(root.left, key, ls);
        if(root.val != key) ls.add(root.val);
        inorder(root.right, key, ls);
    }

    TreeNode bst(List<Integer> ls, int l, int r){
        if(l>r) return null;

        int mid = l + (r-l)/2;

        TreeNode node = new TreeNode(ls.get(mid));
        node.left = bst(ls, l, mid-1);
        node.right = bst(ls, mid+1, r);
        return node;
    }
}