package jianzhi;

/**
 * Created by xyan on 12/19/17.
 */
public class LeftRotateString {
    public static String solution(String str,int n){
        char[] array = str.toCharArray();
        char[] array_copy = new char[array.length];
        for(int i=0;i<array.length;i++){
            int index = (i+array.length-n)%array.length;
            array_copy[index] = array[i];
        }
        System.out.println(String.valueOf(array_copy));
        return String.valueOf(array_copy);
    }

    public static void main(String[] args) {
        String s = "abc123";
        solution(s,6);
    }
}
