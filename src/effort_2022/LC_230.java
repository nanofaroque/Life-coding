package effort_2022;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_230 {
    List<Integer> result;

    public int kthSmallest(TreeNode root, int k) {
        result = new ArrayList<>();
        dfs(root);
        return result.get(k - 1);
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            dfs(node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            dfs(node.right);
        }
    }
}
