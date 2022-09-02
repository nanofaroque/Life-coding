package effort_2022;

import leetcode.TreeNode;

public class LC_1448 {
    int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, root, root.val);
        return count;
    }

    private void dfs(TreeNode root, TreeNode curr, int maxSofar) {
        if (curr == null) return;

        if (curr.val >= maxSofar) {
            maxSofar = Math.max(curr.val, maxSofar);
            count++;
            if (curr.left != null) {
                dfs(curr, curr.left, maxSofar);

            }
            if (curr.right != null) {
                dfs(curr, curr.right, maxSofar);
            }
        } else {
            if (curr.left != null) {
                dfs(curr, curr.left, maxSofar);

            }
            if (curr.right != null) {
                dfs(curr, curr.right, maxSofar);
            }
        }
    }
}
