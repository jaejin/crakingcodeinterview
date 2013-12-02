package ch1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 1.
 * Time: 오후 6:02
 * To change this template use File | Settings | File Templates.
 */
public class ZipCharTest {

    ZipChar zipChar = new ZipChar();

    @Test
    public void testZip() throws Exception {
        assertEquals(zipChar.zip("aaabbbccc"),"a3b3c3");
    }

    @Test
    public void testZip2() throws Exception {
        assertEquals(zipChar.zip("abbccc"),"a1b2c3");
    }

    @Test(expected = NullPointerException.class)
    public void testZip3() throws Exception {
        zipChar.zip(null);
    }

    @Test
    public void testZip4() throws Exception {
        assertEquals(zipChar.zip(""),"");
    }
}
