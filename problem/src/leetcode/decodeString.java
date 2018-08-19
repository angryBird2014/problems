package leetcode;

import java.util.Stack;

public class decodeString {


    public static  String solution(String s){
        Stack<Integer> number_stack = new Stack<Integer>();
        Stack<String> string_stack = new Stack<>();
        String output = "";
        int number = 1;
        for(int i=0;i<s.length();){
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){

                number = s.charAt(i)-'0';
                i++;
                while(i<s.length()&&s.charAt(i)>='0' && s.charAt(i)<='9') {
                    number = number * 10 + s.charAt(i) - '0';
                    i++;
                }
                number_stack.push(number);

            }
            else if (s.charAt(i)=='['){
                string_stack.push(output);
                output = "";
                i++;

            }
            else if (s.charAt(i)==']'){
                StringBuilder s1 = new StringBuilder(string_stack.pop());
                int time = number_stack.pop();
                for (int j = 0;j<time;j++){
                    s1.append(output);
                }
                output = s1.toString();
                i++;
            }
            else {
                output += s.charAt(i);
                i++;
            }

        }
        return output;
    }



    public static void main(String[] args) {
        System.out.println(new decodeString().solution("3[a2[c]]"));
    }
}
