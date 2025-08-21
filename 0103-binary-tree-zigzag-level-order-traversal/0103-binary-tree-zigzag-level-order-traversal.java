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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        boolean toggle = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = q.poll();
                sub.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(toggle) {
                ls.add(sub);
            } else {
                Collections.reverse(sub);
                ls.add(sub);
            }
            toggle = !toggle;
        }
        return ls;
    }
}