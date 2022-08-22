package leetcode.contests.contest_307;

import leetcode.TreeNode;

import java.util.*;

public class BinaryTreeToBeInfected {
    TreeNode startNode = null;

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, TreeNode> parents = new HashMap<>();

        Set<Integer> infected = new HashSet<>();
        parents.put(root.val, null);
        findParents(root, parents);
        System.out.println(parents);
        //TreeNode startNode;
        findStart(root, start);
        //System.out.println(startNode.left.val);

        infected.add(start);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        int result = bfs(queue, -1, parents, infected);
        System.out.println(result);
        return result;
    }

    private int bfs(Queue<TreeNode> queue, int result, Map<Integer, TreeNode> parents, Set<Integer> infected) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            result += 1;
            System.out.println("result: " + result);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !infected.contains(node.left.val)) {
                    infected.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right != null && !infected.contains(node.right.val)) {
                    infected.add(node.right.val);
                    queue.add(node.right);
                }
                TreeNode parent = parents.get(node.val);
                if (parent != null && !infected.contains(parent.val)) {
                    infected.add(parent.val);
                    queue.add(parent);
                }
            }
        }
        return result;
    }

    private void findStart(TreeNode root, int start) {
        if (root.val == start) startNode = root;
        if (root.left != null)
            findStart(root.left, start);
        if (root.right != null)
            findStart(root.right, start);
    }

    private void findParents(TreeNode root, Map<Integer, TreeNode> parents) {
        if (root == null) return;

        if (root.left != null) {
            parents.put(root.left.val, root);
            findParents(root.left, parents);
        }

        if (root.right != null) {
            parents.put(root.right.val, root);
            findParents(root.right, parents);
        }
    }
}
