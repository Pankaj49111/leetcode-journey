/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        System.out.println("ip: "+sb.toString().substring(0,sb.length()-1));
        return sb.toString().substring(0,sb.length()-1);
    }

    void preorder(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("null");
            sb.append(",");
        } else {
            sb.append(root.val);
            sb.append(",");
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }
    
    int idx=0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return reconstruct(split);
    }

    TreeNode reconstruct(String[] arr){
        if(arr[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = reconstruct(arr);
        node.right = reconstruct(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));