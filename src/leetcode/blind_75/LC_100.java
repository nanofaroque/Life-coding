package leetcode.blind_75;

import leetcode.TreeNode;

public class LC_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

    }
}
