package effort_2022;

import java.util.HashMap;
import java.util.Map;

public class LC_138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next,Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
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
