package dailycodings;

import leetcode.ListNode;

public class DailyCoding_1132 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        DailyCoding_1132 p = new DailyCoding_1132();
        p.rotateRight(head, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode root = new ListNode();

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        k = k % count;
        if (k == 0) return head;
        for (int i = 0; i < k; i++) {
            root = new ListNode();
            root.next = head;
            while (head.next != null && head.next.next != null) {
                head = head.next;
            }
            int v = head.next.val;
            head.next = null;
            root.val = v;
            head = root;
        }
        return root;
    }
}
