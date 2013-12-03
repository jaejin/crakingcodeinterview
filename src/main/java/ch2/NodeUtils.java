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

    // 2.5
    public static Node sum(Node one,Node two) {
        Node result = new Node(one.data + two.data);


        Node node = result;

        while (one.next != null || two.next != null) {
            if (one.next != null && two.next != null) {
                result.next = new Node(one.next.data + two.next.data);
                one = one.next;
                two = two.next;
            } else if ( one.next != null ) {
                result.next = new Node(one.next.data);
                one = one.next;
            } else if ( two.next != null ) {
                result.next = new Node(two.next.data);
                two = two.next;
            }

            node = result.next;
        }
    }
}
