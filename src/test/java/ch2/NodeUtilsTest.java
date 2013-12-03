package ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 3.
 * Time: 오전 7:08
 * To change this template use File | Settings | File Templates.
 */

public class NodeUtilsTest {

    private NodeUtils nodeUtils;

    @Before
    public void before() {
        nodeUtils = new NodeUtils();
    }

    public Node makeDuplicateNodeData() {
        Node head = new Node(1);

        Node two  = new Node(2);
        head.next = two;

        Node three = new Node(3);
        two.next = three;

        Node one = new Node(1);
        three.next = one;
        Node twod = new Node(2);
        one.next = twod;
        Node threed = new Node(3);
        twod.next = threed;

        return head;
    }

    public Node makeNodeData() {
        Node head = new Node(1);

        Node two  = new Node(2);
        head.next = two;

        Node three = new Node(3);
        two.next = three;

        Node one = new Node(6);
        three.next = one;
        Node twod = new Node(4);
        one.next = twod;
        Node threed = new Node(5);
        twod.next = threed;

        return head;
    }

    @Test
    public void testMakeDuplicateData() {
        assertEquals("1->2->3->1->2->3", makeDuplicateNodeData().printNode());
    }


    @Test()
    public void testDuplicate() throws Exception {
        assertEquals("1->2->3", nodeUtils.duplicate(makeDuplicateNodeData()).printNode());
    }

    @Test
    public void testIndexOf1() throws  Exception {
        assertEquals(1,nodeUtils.indexOf(makeDuplicateNodeData(),0));
    }

    @Test
    public void testIndexOf2() throws  Exception {
        assertEquals(3,nodeUtils.indexOf(makeDuplicateNodeData(),2));
    }

    @Test
    public void testSplit() throws Exception {

        Node node = makeNodeData();
        System.out.println(node.printNode());

        Node[] nodes = NodeUtils.split(makeNodeData(),6);

//        assertEquals("1->2->3",nodes[0].printNode());
    }
}
