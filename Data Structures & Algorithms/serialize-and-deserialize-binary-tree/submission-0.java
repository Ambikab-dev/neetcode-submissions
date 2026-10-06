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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serializeHelper(root, res);
        return res.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder res){
        if (root == null) {
            res.append("#,");
            return;
        }
        res.append(root.val).append(",");
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String values[] = data.split(",");
        int index[] = {0};
        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(String[] values, int[] index){
        String value = values[index[0]++];
        if (value.equals("#")) return null;
        TreeNode node = new TreeNode (Integer.parseInt(value));
        node.left = deserializeHelper(values, index);
        node.right = deserializeHelper(values, index);
        return node;
    }
}
