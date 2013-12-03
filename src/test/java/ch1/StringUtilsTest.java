package ch1;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 2013. 12. 3.
 * Time: 오전 11:07
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {


    @Test
    public void testIsSubstring() {
        String a = "waterbottle";
        String b = "erbottlewat";

        assertEquals(true, StringUtils.isSubstring(a, b));

    }


    @Test
    public void testIsSubstring2() {
        String a = "waterbottle";
        String b = "erbottleaaawat";

        assertFalse(StringUtils.isSubstring(a, b));

    }

    @Test
    public void testIsSubstring3() {
        String a = "waterbottle";
        String b = "erbottleaaa";

        assertFalse(StringUtils.isSubstring(a, b));

    }


    @Test
    public void testZip() throws Exception {
        assertEquals(StringUtils.zip("aaabbbccc"),"a3b3c3");
    }

    @Test
    public void testZip2() throws Exception {
        assertEquals(StringUtils.zip("abbccc"),"a1b2c3");
    }

    @Test(expected = NullPointerException.class)
    public void testZip3() throws Exception {
        StringUtils.zip(null);
    }

    @Test
    public void testZip4() throws Exception {
        assertEquals(StringUtils.zip(""),"");
    }


    @Test
    public void testComparedToPermutation() throws Exception {
        assertTrue(StringUtils.comparedToPermutation("abc","bca"));
    }

    @Test
    public void testComparedToPermutation2() throws Exception {
        assertFalse(StringUtils.comparedToPermutation("abc","bcaaaa"));
    }
}

