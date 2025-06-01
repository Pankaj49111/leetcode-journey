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
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        store(root, ls);
        Collections.reverse(ls);
        convert(root, ls);
        return root;
    }

    void store(TreeNode node, List<Integer> ls){
        if(node == null) return;

        store(node.left, ls);
        ls.add(node.val);
        store(node.right, ls);
    }

    void convert(TreeNode root, List<Integer> ls){
        if(root == null) return;

        convert(root.left, ls);
        convert(root.right, ls);

        int sum=0;

        for(int num: ls){
            if(num > root.val){
                sum += num;
            } else {
                break;
            }
        }
        root.val += sum;
    }
}