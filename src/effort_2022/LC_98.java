package effort_2022;

import leetcode.TreeNode;

public class LC_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // high is for right child
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) return false;

        boolean left = dfs(root.left, low, root.val);
        boolean right = dfs(root.right, root.val, high);

        return left && right;
    }
}
