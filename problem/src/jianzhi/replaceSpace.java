package jianzhi;

/**
 * Created by xyan on 10/5/17.
 */
public class replaceSpace {

    public static String replace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%2d");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println(replace(str));
    }
}


