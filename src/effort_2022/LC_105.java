package effort_2022;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC_105 {
    Map<Integer, Integer> indexMap;
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int left = 0;
        int right = inorder.length - 1;
        return build(preorder, inorder, left, right);
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) return null;
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, inorder, left, indexMap.get(val) - 1);
        root.right = build(preorder, inorder, indexMap.get(val) + 1, right);
        return root;
    }
}
