package effort_2022;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(root);
    }
    class Node{
        char ch;
        boolean isWord;
        Map<Character,Node> child;
        Node(char c){
            this.ch=c;
            this.child=new HashMap<>();
            this.isWord=false;
        }
    }

    static Node root;
    public Trie() {
        root=new Node('#');
    }

    public void insert(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if (temp.child.containsKey(ch)){
                temp=temp.child.get(ch);
            }else{
                temp.child.put(ch,new Node(ch));
                temp=temp.child.get(ch);
            }
        }
        temp.isWord=true;

    }

    public boolean search(String word) {
        Node temp=root;
        for(char c: word.toCharArray()){
            if(temp.child.containsKey(c)){
                temp=temp.child.get(c);
            }else return false;
        }
        if(!temp.isWord) return false;
        return true;
    }

    public boolean startsWith(String prefix) {

        Node temp=root;
        for(char c: prefix.toCharArray()){
            if(temp.child.containsKey(c)){
                temp=temp.child.get(c);
            }else return false;
        }
        return true;
    }
}
