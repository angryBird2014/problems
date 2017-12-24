package jianzhi;

/**
 * Created by xyan on 12/20/17.
 */
public class ReverseSentence {
    public static String solution(String str){
        String result = "";
        result = reverseString(str);
        String[] words = result.split(" ");
        if (words.length==0){
            System.out.println(str.length());
            return str;
        }

        result  =reverseString(words[0]);
        for (int i=1;i<words.length;i++){
            result = result + " "+reverseString(words[i]);
        }
        System.out.println(result);
        return result;
    }

    public static String reverseString(String str){
        String result = "";
        char[] array = str.toCharArray();
        char[] array_copy = new char[array.length];
        for (int i=0;i<array.length;i++){
            array_copy[array.length-1-i] = array[i];
        }
        result = String.valueOf(array_copy);
        return result;
    }

    public static void main(String[] args) {
        solution("asds");
    }
}
