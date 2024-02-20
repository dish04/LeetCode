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
class invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode ret;
        if(root == null)return null;
        else ret = new TreeNode(root.val,invertTree(root.right),invertTree(root.left));
        return ret;
    }
}
