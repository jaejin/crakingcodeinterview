package ch1;

/**
 * Created with IntelliJ IDEA.
 * User: jaejinyun
 * Date: 2013. 12. 1.
 * Time: 오후 5:22
 * To change this template use File | Settings | File Templates.
 */
public class UniqueWord {

    private int[] chars = new int[128];

    public UniqueWord() {
        for (int i = 0; i < chars.length;i++ )  {
            chars[i] = 0;
        }
    }

    public boolean isUsedUniqueWord(String words) {
        for(char c : words.toCharArray()) {
            if(chars[(int)c] != 0) {
                return false;
            } else {
                chars[(int)c]++;
            }
        }
        return true;
    }
}
