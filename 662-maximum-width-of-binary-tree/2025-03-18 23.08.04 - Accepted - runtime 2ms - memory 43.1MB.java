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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        int max = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int minIdx = q.peek().getValue();

            int fst=0, last=0;

            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode node = pair.getKey();
                int idx = pair.getValue() - minIdx;

                if(i == 0) fst = idx;
                if(i == size-1) last = idx;

                if(node.left != null)
                    q.offer(new Pair<>(node.left, 2*idx));

                if(node.right != null)
                    q.offer(new Pair<>(node.right, 2*idx+1));
            }
            max = Math.max(max, last - fst + 1);
        }
        return max;
    }
}