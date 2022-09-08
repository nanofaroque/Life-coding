package effort_2022;

import leetcode.TreeNode;

class LC_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        
        return dfs(root);
    }
    private TreeNode dfs(TreeNode root){
        if(root==null) return root;
        
        if(root.left!=null && root.right!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=temp;
        }else if(root.left==null){
            root.left=root.right;
            root.right=null;
        }else{
            root.right=root.left;
            root.left=null;
        }
        dfs(root.left);
        dfs(root.right);
        return root; 
    }
}
