package effort_2022;

import leetcode.TreeNode;

public class LC_297 {
    // Encodes a tree to a single string.
    String sb;
    int idx = 0;

    public String serialize(TreeNode root) {
        sb = "";
        inorder(root);
        System.out.println(sb);
        return sb.toString();
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            sb = sb + "null#";
            return;
        }

        sb = sb + String.valueOf(root.val) + "#";
        inorder(root.left);
        inorder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split("#");
        idx = 0;
        return des(d);
        //return root;
    }

    private TreeNode des(String[] data) {
        if (data[idx].equals("null")) return null;
        //else return data[idx];
        TreeNode root = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        root.left = des(data);
        idx++;
        root.right = des(data);
        return root;

    }
}
