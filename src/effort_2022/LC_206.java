package effort_2022;


import leetcode.ListNode;

public class LC_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        LC_206 p = new LC_206();
        p.reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode left = head;

        if (head == null) return head;
        if (head.next == null) return head;


        while (head != null && head.next != null) {
            ListNode right = head.next;//2
            left = head;//1
            ListNode temp = null;
            if (right.next != null) {
                temp = right.next; //3
            }
            right.next = left;
            left.next = dummy;
            dummy = right;
            head = temp;
        }
        if (head != null)
            head.next = dummy;
        else
            head = dummy;
        return head;
    }
}
