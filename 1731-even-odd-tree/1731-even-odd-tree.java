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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        boolean toggle = true;

        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                ls.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            int lsize = ls.size();
            if(lsize == 1){
                if(toggle){
                    if(ls.get(0) % 2 == 0) return false;
                } else {
                    if(ls.get(0) % 2 != 0) return false;
                }
            }
            if(lsize>1){
                if(toggle){
                    for(int i=1; i<lsize; i++){
                        if(ls.get(i-1) % 2 == 0 || ls.get(i) % 2 == 0) return false;
                        if(ls.get(i-1)>=ls.get(i)) return false;
                    }
                } else {
                    for(int i=1; i<lsize; i++){
                        if(ls.get(i-1) % 2 != 0 || ls.get(i) % 2 != 0) return false;
                        if(ls.get(i-1)<=ls.get(i)) return false;
                    }
                }
            }
            toggle = !toggle;
        }
        return true;
    }
}