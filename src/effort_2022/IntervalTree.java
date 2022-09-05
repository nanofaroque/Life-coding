package effort_2022;

public class IntervalTree {
    static class Interval {
        int low, high;

        Interval(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public String toString() {
            return "[" + this.low + "," + this.high + "]";
        }
    }

    static class Node {
        Interval range;
        Node left, right;
        int max;

        Node(Interval range, int max) {
            this.range = range;
            this.max = max;
        }

        public String toString() {
            return "[" + this.range.low + ", "
                    + this.range.high + "] "
                    + "max = " + this.max + "\n";
        }
    }

    Node root = null;

    public static void main(String[] args) {
        Node root = insert(null, new Interval(15, 20));
        root = insert(root, new Interval(10, 30));
        root = insert(root, new Interval(17, 19));
        root = insert(root, new Interval(5, 20));
        root = insert(root, new Interval(12, 15));
        root = insert(root, new Interval(30, 40));

        System.out.println(
                "Inorder traversal of constructed Interval Tree is");
        inOrder(root);
        System.out.println();
        Interval i = new Interval(6, 7);
        System.out.println("Searching for interval " + i);
        System.out.println(
                "Overlaps with "
                        + isOverlapping(root, new Interval(6, 7)));
    }

    public static Node insert(Node root, Interval interval) {
        if (root == null) {
            root = new Node(interval, interval.high);
            return root;
        }

        if (interval.low < root.range.low) {
            root.left = insert(root.left, interval);
            root.max = Math.max(root.max, interval.high);
        } else {
            root.right = insert(root.right, interval);
            root.max = Math.max(root.max, interval.high);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root);
        inOrder(root.right);
    }

    public static Interval isOverlapping(Node root,
                                         Interval x) {
        if (root == null) return new Interval(-1, -1);
        if ((x.low > root.range.low && x.low < root.range.high) ||
                (x.high > root.range.low && x.high < root.range.high)) {
            return root.range;
        }

        if (root.left != null && root.left.max > x.low) {
            return isOverlapping(root.left, x);
        } else {
            return isOverlapping(root.right, x);
        }
    }


}
