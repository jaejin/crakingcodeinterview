package ch2;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

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

    static Logger logger = Logger.getLogger(NodeUtils.class);
    // 2.1
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

    // 2.2
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

    //2.4
    public static Node[] split(Node head,int i) {
        Node n = head;

        Node[] nodes = new Node[2];

        Node arrayHead1 =null;
        Node arrayHead2 = null;


        if ( n.data >= i ) {
            logger.debug(" node[0] n.data in for " + n.data);
            nodes[0] = new Node(n.data);
            arrayHead1 = nodes[0];
        } else {
            logger.debug(" node[1] n.data in for " + n.data);
            nodes[1] = new Node(n.data);;
            logger.debug(nodes[1].printNode());
            arrayHead2 = nodes[1];
        }
        if(nodes[0] != null) {
            logger.debug("node[0]="+nodes[0].printNode());
        }

        if(nodes[1] != null) {
            logger.debug("node[1]="+nodes[1].printNode());
        }




        while(n.next != null) {



            if(n.next.data >= i ) {
                logger.debug(" head[1] n.next.data in for " + n.next.data);
                if(arrayHead1 == null ) {
                    arrayHead1 = new Node(n.next.data);
                    nodes[0] = arrayHead1;
                } else {
                    arrayHead1.next = new Node(n.next.data);
                    arrayHead1 = arrayHead1.next;
                }

            } else {
                logger.debug(" head[2] n.next.data in for " + n.next.data);
                if(arrayHead2 == null ) {
                    arrayHead2 = new Node(n.next.data);
                    nodes[1] = arrayHead2;
                } else {
                    arrayHead2.next = new Node(n.next.data);
                    arrayHead2 = arrayHead2.next;
                }
            }

            n = n.next;
        }


        logger.debug("node[0]="+nodes[0].printNode());
        logger.debug("node[1]="+nodes[1].printNode());

        return nodes;
    }

    public static Node lastRemove(Node head) {
        Node node =head;

        while (node.next.next != null )   {
            node = node.next;
        }

        node.next = null;

        return head;
    }

    public static Node lastNode(Node head) {
        Node node =head;

        while (node.next != null )   {
            node = node.next;
        }

        return node;
    }

    public static Node append(Node head,Node tail) {
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = tail;
        return head;
    }

    public static Node reverse(Node head) {
        if( head.next== null)
            return head;
        return append(reverse(head.next),new Node(head.data));
    }

    public static Node sumHelper(Node head, Node result, Node one, Node two) {
        if(one == null &&  two == null ) {
            if( lastNode(head).data == 0 ) {
                return lastRemove(head);
            } else {
                return head;
            }

        }

        if(result == null) {
            result = new Node(0);
        }

        if (one != null && two != null) {

            int data = (one.data + two.data+result.data)%10;
            int adder = (one.data + two.data+result.data)/10;

            result.data = data;
            result.next = new Node(adder);

            one = one.next;
            two = two.next;
        } else if ( one != null ) {
            int data = (one.data +result.data)%10;
            int adder = (one.data+result.data)/10;

            result.data = data;
            result.next = new Node(adder);

            one = one.next;
        } else if ( two != null ) {

            int data = (two.data +result.data)%10;
            int adder = (two.data+result.data)/10;

            result.data = data;
            result.next = new Node(adder);


            two = two.next;
        }

        return sumHelper(head, result.next, one, two);
    }

    // 2.5
    public static Node sum(Node one,Node two) {
        Node result = new Node(0);

        Node head = result;
        int data = (one.data + two.data)%10;
        int adder = (one.data + two.data)/10;

        result.data = data;
        result.next = new Node(adder);

        return sumHelper(head, result.next,one.next,two.next);
    }

    // 2.5-2
    public static Node sum2(Node one,Node two) {
        return reverse(sum(reverse(one), reverse(two))) ;
    }

    // 2.6
    public static int circulate(Node one) {
        Set<Integer> set = new HashSet<Integer>();

        while(one.next != null) {

            if(set.contains(one.data)) {
                return one.data;
            }

            set.add(one.data);
            one = one.next;
        }

        if(set.contains(one.data)) {
            return one.data;
        }

        return -1;
    }

    public static boolean isPalidrome(Node one) {
        return one.printNode().equals(reverse(one).printNode());
    }
}
