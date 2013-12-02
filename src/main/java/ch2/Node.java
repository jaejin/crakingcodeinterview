package ch2;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 3.
 * Time: 오전 6:59
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    Node next = null;
    int data;

    public Node(int d)  {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while( n.next != null )  {
            n = n.next;
        }

        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next;
        }

        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head;
            }

            n = n.next;
        }

        return head;
    }

    public String printNode() {
        Node n = this.next;
        StringBuffer result = new StringBuffer() ;
        result.append(this.data);

        while(n.next != null) {
            result.append("->").append(n.data);
            n = n.next;
        }

        if (n != null) {
            result.append("->").append(n.data);
        }

        return result.toString();
    }
}
