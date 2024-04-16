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
class add_one_row_to_tree {
    public TreeNode addOneRow1(TreeNode root, int val, int depth, int dived, boolean left) {
        if(root == null && dived != depth-1) return null;
        if(root == null && dived == depth-1) return new TreeNode(val);
        if(dived == depth-1 && left) return new TreeNode(val,root,null);
        if(dived == depth-1 && !left) return new TreeNode(val,null,root);
        return new TreeNode(root.val,addOneRow1(root.left,val,depth,dived+1,true),addOneRow1(root.right,val,depth,dived+1,false));
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth){
        if(depth == 1) return new TreeNode(val,root,null);
        return new TreeNode(root.val,addOneRow1(root.left,val,depth,1,true),addOneRow1(root.right,val,depth,1,false));
    }
}
