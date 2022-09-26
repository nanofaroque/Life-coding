package effort_2022;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_1110 {
    public static void main(String[] args) {
        LC_1110 p = new LC_1110();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        p.delNodes(root, new int[]{3, 5});
        System.out.println(result);
    }

    static List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();

        Set<Integer> toDel = new HashSet<>();
        for (int del : to_delete) toDel.add(del);

        mark(root, toDel);

        TreeNode prev = new TreeNode(-1);
        prev.left = root;
        dfs(prev, true, root);
        return result;
    }

    private void mark(TreeNode root, Set<Integer> toDel) {
        if (root == null) return;
        if (toDel.contains(root.val)) {
            root.val = -1;
        }
        mark(root.left, toDel);
        mark(root.right, toDel);
    }

    private void dfs(TreeNode prev, boolean left,  TreeNode node) {
        if (node == null) return;
        if(node.val==-1){
            if(left){
                prev.left=null;
            }else
                prev.right=null;
        }else{
            if(prev.val==-1) result.add(node);
        }
        dfs(node, true, node.left);
        dfs(node, false, node.right);
    }
}
