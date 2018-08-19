package leetcode;

class TrieNode {
    char value;
    boolean word=false;
    TrieNode[] childrens = new TrieNode[26];
    TrieNode(){}
    TrieNode(char value){
        TrieNode node = new TrieNode();
        node.value = value;
    }

}

public class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
        root.value = ' ';
    }
    public void  insert(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if (ws.childrens[word.charAt(i)-'a']==null)
                ws.childrens[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
            ws = ws.childrens[word.charAt(i)-'a'];
        }
        ws.word = true;
    }
    public boolean search(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            if (ws.childrens[word.charAt(i)-'a']==null)
                return false;
            ws = ws.childrens[word.charAt(i)-'a'];
        }
        return ws.word;
    }

    public boolean startWith(String word){
        TrieNode ws = root;
        for(int i = 0;i<word.length();i++){
            if (ws.childrens[word.charAt(i)-'a']==null)
                return false;
            ws = ws.childrens[word.charAt(i)-'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie solution = new Trie();
        solution.insert("aaa");
        solution.insert("a");
        solution.insert("sfe");
        System.out.println(solution.search("ddd"));
        System.out.println(solution.startWith("aa"));
        System.out.println(solution.search("aaaa"));

    }
}


