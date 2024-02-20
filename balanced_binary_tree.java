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
class blanced_binary_tree {
    private static boolean f = true;
    private static boolean t = true;
    private static int rec(TreeNode root){
        
        if(root == null) return 0;
        else{
            int left = rec(root.left);
            int right = rec(root.right);
            if(Math.abs(left-right)>1) f = false;
            return Math.max(left,right)+1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        f = true;
        rec(root);
        if (t && f) return true;
        else return false;
    }
}
