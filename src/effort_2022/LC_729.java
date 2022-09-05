package effort_2022;

public class LC_729 {
    public static void main(String[] args) {
        LC_729 p=new LC_729();
        p.book(47,50);
        p.book(33,41);
        p.book(39,45);
        p.book(33,42);
    }
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

    Node head;

    public LC_729() {
        this.head=null;
    }

    public boolean book(int start, int end) {
        Interval in = isOverlapping(head,new Interval(start,end));
        if(in.low ==-1 && in.high==-1){
            this.head= insert(this.head,new Interval(start,end));
            return true;
        }
        return false;
    }

    private Node insert(Node root, Interval x){
        if (root == null) {
            return new Node(x, x.high);
        }
        if (x.low < root.range.low) {
            root.left = insert(root.left, x);
        }
        else {
            root.right = insert(root.right, x);
        }
        if (root.max < x.high) {
            root.max = x.high;
        }
        return root;
    }

    private Interval isOverlapping(Node root, Interval x){
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
