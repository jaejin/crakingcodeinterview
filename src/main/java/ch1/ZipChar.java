package ch1;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 1.
 * Time: 오후 5:50
 * To change this template use File | Settings | File Templates.
 */
public class ZipChar {


    public String zip(String word) {
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
}
