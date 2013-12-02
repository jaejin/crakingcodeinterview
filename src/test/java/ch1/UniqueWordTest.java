package ch1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 1.
 * Time: 오후 5:23
 * To change this template use File | Settings | File Templates.
 */
public class UniqueWordTest {

    UniqueWord uniqueWord;

    @Before
    public void setUp() throws Exception {
        uniqueWord= new UniqueWord();
    }

    @Test
    public void testIsUsedUniqueWord() {

        assertTrue(uniqueWord.isUsedUniqueWord("abcdefg"));
    }

    @Test
    public void testIsUsedUniqueWord2() {

        assertFalse(uniqueWord.isUsedUniqueWord("abcdefaaa"));
    }

    @After
    public void tearDown() throws Exception {

    }


}
