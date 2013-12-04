package ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        Node[] nodes = NodeUtils.split(makeNodeData(),3);

        assertEquals("1->2",nodes[1].printNode());
    }


    public Node makeNodeDataFromString(String nums) {
        Node head= new Node(nums.charAt(0)-48);

        Node node = head;
        for(int i=1;i<nums.length();i++) {
            Node end = new Node(nums.charAt(i)-48);
            node.next = end;
            node = node.next;
        }
        return head;
    }

    @Test
    public void testSum() throws Exception {

        Node first =makeNodeDataFromString("716");
        Node second =makeNodeDataFromString("592");

        assertEquals("2->1->9", NodeUtils.sum(first, second).printNode());

    }

    @Test
    public void testSum2() throws Exception {

        Node first =makeNodeDataFromString("717");
        Node second =makeNodeDataFromString("592");

        assertEquals("2->1->0->1",NodeUtils.sum(first,second).printNode());

    }

    @Test
    public void testSum3() throws Exception {

        Node first =makeNodeDataFromString("717");
        Node second =makeNodeDataFromString("59");

        assertEquals("2->1->8",NodeUtils.sum(first,second).printNode());

    }

    @Test
    public void testAppend() throws Exception {

        Node first =makeNodeDataFromString("595");
        Node tail =makeNodeDataFromString("7");

        assertEquals("5->9->5->7",NodeUtils.append(first,tail).printNode());

    }
    @Test
    public void testReverse() throws Exception {

        Node first =makeNodeDataFromString("597");

        assertEquals("7->9->5",NodeUtils.reverse(first).printNode());

    }

    @Test
    public void testSum5() throws Exception {

        Node first =makeNodeDataFromString("617");
        Node second =makeNodeDataFromString("295");

        assertEquals("9->1->2",NodeUtils.sum2(first, second).printNode());
    }


    @Test
    public void isPalindrome() throws Exception {

        Node first =makeNodeDataFromString("717");
        assertTrue(NodeUtils.isPalidrome(first));

        first =makeNodeDataFromString("715");
        assertFalse(NodeUtils.isPalidrome(first));
    }

    @Test
    public void testCirculate() throws Exception {

        Node first =makeNodeDataFromString("123453");
        assertEquals(3,NodeUtils.circulate(first));
    }


}
