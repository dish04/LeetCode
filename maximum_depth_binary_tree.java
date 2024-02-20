class maximum_depth_binary_tree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }
}
