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
class smallest_String_starting_from_leaf {
    int minLength = Integer.MAX_VALUE;
    int minSum = Integer.MAX_VALUE;
    String lex = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    public int dfs(TreeNode root,String s,int len){
        if(root == null) return 0;
        s = Character.toString((char)(root.val+97))+s;
        int result = s.compareTo(lex);
        if(root.left == null && root.right == null && result < 0 && len <= minLength){
            lex = s;
            return 0;
        }
        if(root.left == null && root.right == null)return 0;
        if(len>minLength)return 0;
        dfs(root.left,s,len+1);
        dfs(root.right,s,len+1);
        return 0;
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"",1);
        //StringBuilder revRet = new StringBuilder(retString).reverse(); 
        return lex;
    }
}
