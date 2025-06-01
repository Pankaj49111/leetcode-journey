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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        storeRoot(root1, l1);
        storeRoot(root2, l2);

        return l1.size() == l2.size() &&
                IntStream.range(0, l1.size())
                        .allMatch(i -> l1.get(i).equals(l2.get(i)));
    }

    void storeRoot(TreeNode root, List<Integer> list){
        if(root == null) return;

        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        storeRoot(root.left, list);
        storeRoot(root.right, list);
    }
}