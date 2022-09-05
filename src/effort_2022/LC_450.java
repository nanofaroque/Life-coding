package effort_2022;

import leetcode.TreeNode;

public class LC_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        return delete(root, key);


    }

    public int suc(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public int pre(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) root.right = delete(root.right, key);
        else if (key < root.val) root.left = delete(root.left, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                root.val = suc(root);
                root.right = delete(root.right, root.val);
            } else {
                root.val = pre(root);
                root.left = delete(root.left, root.val);
            }
        }

        return root;
    }
}
