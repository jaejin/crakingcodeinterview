package ch1;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 1.
 * Time: 오후 5:42
 * To change this template use File | Settings | File Templates.
 */
public class PermutationTest {

    Permutation permutation = new Permutation();


    @Test
    public void testComparedToPermutation() throws Exception {
        assertTrue(permutation.comparedToPermutation("abc","bca"));
    }

    @Test
    public void testComparedToPermutation2() throws Exception {
        assertFalse(permutation.comparedToPermutation("abc","bcaaaa"));
    }
}
