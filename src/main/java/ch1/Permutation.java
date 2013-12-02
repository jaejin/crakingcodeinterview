package ch1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 1.
 * Time: 오후 5:38
 * To change this template use File | Settings | File Templates.
 */
public class Permutation {

    public boolean comparedToPermutation(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);


        return Arrays.equals(a,b);

    }
}
