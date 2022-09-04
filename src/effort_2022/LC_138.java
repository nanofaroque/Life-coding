package effort_2022;

import java.util.HashMap;
import java.util.Map;

public class LC_138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node seven=new Node(7);
        Node thirteen=new Node(13);
        Node eleven=new Node(11);
        Node ten=new Node(10);
        Node one=new Node(1);

        seven.next=thirteen;
        seven.random=null;

        thirteen.next=eleven;
        thirteen.random=seven;

        eleven.next=ten;
        eleven.random=one;

        ten.next=one;
        ten.random=eleven;

        one.next=null;
        one.random=seven;

        LC_138 p = new LC_138();
        p.copyRandomList(seven);


    }
    Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head==null) return null;

        if(visited.containsKey(head)) return visited.get(head);

        Node n = new Node(head.val,null,null);

        visited.put(head,n);
        n.next=copyRandomList(head.next);
        n.random=copyRandomList(head.random);

        return n;
    }
}
