package ch2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 3.
 * Time: 오전 7:03
 * To change this template use File | Settings | File Templates.
 */
public class NodeUtils {

    public Node duplicate(Node head) {
        if(head == null ) {
           throw new NullPointerException();
        }

        Set<Integer> dup = new HashSet<Integer>();
        Node n = head;

        dup.add(n.data);

        while(n.next != null) {
            if(dup.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                dup.add(n.next.data);
                n = n.next;
            }

        }
        return head;
    }

    public int indexOf(Node head,int index) {
        Node n = head;


        if(index < 0 ) {
            return -1;
        }

        if (index == 0) {
            return n.data;
        }
        index--;

        while(n.next != null) {
            if(index == 0 ) {
                return n.next.data;
            }
            n = n.next;
            index--;
        }

        return -1;
    }
}
