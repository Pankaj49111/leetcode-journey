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
    public int kthSmallest(TreeNode root, int k) {
        // List<Integer> ls = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        inorder(root, pq, k);
        return pq.poll();
    }

    void inorder(TreeNode root, PriorityQueue<Integer> pq, int k){
        if(root == null) return;

        inorder(root.left, pq, k);
        pq.offer(root.val);
        if(pq.size() > k) pq.poll();
        inorder(root.right, pq, k);
    }
}