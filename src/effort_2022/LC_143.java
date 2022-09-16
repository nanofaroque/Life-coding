package effort_2022;

import leetcode.ListNode;

public class LC_143 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        LC_143 p=new LC_143();
        p.reorderList(head);
    }
    public void reorderList(ListNode head) {
        if (head == null) return;

        // find the middle of linked list [Problem 876]
        // in 1->2->3->4->5->6 find 4
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev= reverseList(slow);

        System.out.println(rev);
        ListNode first = head, second = rev;

        while (second.next!=null){
            ListNode tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }

        System.out.println(head);
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
        if(head!=null)
            head.next = dummy;
        else
            head=dummy;
        return head;
    }
}
