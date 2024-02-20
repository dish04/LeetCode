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
class diameter_of_binary_tree {
    private static int maxSum = 0;
    private static int goLong(TreeNode root){
        if(root == null) return 0;
        int left = goLong(root.left);
        int right = goLong(root.right);
        maxSum = Math.max(maxSum,left+right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxSum = 0;
        goLong(root);
        return maxSum;
    }
}
