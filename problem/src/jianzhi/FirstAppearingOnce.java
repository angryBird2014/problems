package jianzhi;

/**
 * Created by xyan on 1/22/18.
 */
public class FirstAppearingOnce {
    int[] hashmap = new int[256];
    StringBuffer str = new StringBuffer();
    public char solution(){
        char[] array = str.toString().toCharArray();
        for (char s:array) {
            if (hashmap[s]==1)
                return s;
        }
        return '#';
    }

    public void Insert(char ch){
        str.append(ch);
        if (hashmap[ch]==1)
            hashmap[ch]=-1;
        else
            hashmap[ch]=1;
    }

    public static void main(String[] args) {
        FirstAppearingOnce s = new FirstAppearingOnce();
        s.Insert('g');
        s.Insert('o');
        s.Insert('o');
        s.Insert('g');
        s.Insert('l');
        System.out.println(s.solution());
    }
}
