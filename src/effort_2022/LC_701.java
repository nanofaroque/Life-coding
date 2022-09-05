package effort_2022;

import leetcode.TreeNode;

public class LC_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return dfs(root,val);
    }
    private TreeNode dfs(TreeNode root, int val){
        if(root==null) {
            return new TreeNode(val);
        }

        if(val<root.val){
            root.left = dfs(root.left, val);
        }
        else{
            root.right = dfs(root.right, val);
        }
        return root;
    }
}
