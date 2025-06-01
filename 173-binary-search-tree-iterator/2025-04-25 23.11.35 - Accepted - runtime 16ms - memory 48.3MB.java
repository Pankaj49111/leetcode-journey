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
class BSTIterator {
    private List<Integer> list = new ArrayList<>();
    private int index=0;
    private void InOrderTraversal(TreeNode root){
        if(root==null) return; 
        InOrderTraversal(root.left);
        list.add(root.val);
        InOrderTraversal(root.right);
    }
    public BSTIterator(TreeNode root) {
        InOrderTraversal(root);
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return list.size()>index;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */