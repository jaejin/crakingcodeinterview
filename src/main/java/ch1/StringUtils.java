package ch1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 2013. 12. 3.
 * Time: 오전 11:07
 * To change this template use File | Settings | File Templates.
 */
public class StringUtils {


    public static boolean isSubstring(String origin, String another) {

        if(origin.length() != another.length()) {
            return false;
        }

        for(int i = 0;i<origin.length();i++) {

            String before = origin.substring(i);
            String after = another.substring(0,origin.substring(i).length());
            if(  another.startsWith(before) && another.equals(before+origin.substring(0,i)) ) {
                return true;
            }
        }

        return false;
    }


    public static String zip(String word) {
        if (word == null) {
            throw new NullPointerException();
        }
        if(word == "")  {
            return "";
        }

        String zip = "";
        char prevc = word.charAt(0);

        int count = 1;
        for(int i = 1;i<word.length();i++ ) {
            if (prevc != word.charAt(i)) {
                zip = zip +"" + prevc+""+count;
                prevc = word.charAt(i);
                count = 1;
            } else  {
                count++;
            }
        }

        zip = zip +"" + prevc+""+count;
        return zip;
    }

    public static boolean comparedToPermutation(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);


        return Arrays.equals(a,b);

    }

}
