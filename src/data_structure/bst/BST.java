package data_structure.bst;

import leetcode.TreeNode;

public class BST {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] input = new int[]{4, 2, 7, 5, 0, 6, 2, 1};
        for (int in : input) {
            bst.insert(in);
        }
        System.out.println(bst);
        printBST(bst.root);
    }

    private static void printBST(TreeNode root) {
        if (root == null) return;
        printBST(root.left);
        System.out.println(root.val);
        printBST(root.right);
    }

    TreeNode root;

    public BST() {
        root = null;
    }

    public void insert(int val) {
        this.root = insert(root, val);
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val >= root.val) {
            root.right = insert(root.right, val);

        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val >= root.val) {
            root.right = insert(root.right, val);

        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }
}
