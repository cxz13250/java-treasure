package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母
 * @Date: Created in 下午4:35 2018/6/29
 * @Modified By:
 */
public class LeetCode211 {

    static class WordDictionary {

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root=new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word != null){
                Map<Character, TrieNode> children=root.children;
                for (int i=0;i<word.length();i++){
                    char c=word.charAt(i);
                    TrieNode t;
                    if (children.containsKey(c)){
                        t=children.get(c);
                    }else {
                        t=new TrieNode(c);
                        children.put(c, t);
                    }
                    children=t.children;
                    if (i==word.length()-1){
                        t.isLeaf=true;
                    }
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchNode(word, root);
        }

        public boolean searchNode(String word,TrieNode node){
            if (node==null){
                return false;
            }
            if (word.length()==0){
                return node.isLeaf;
            }
            Map<Character, TrieNode> children=node.children;
            TrieNode t=null;
            char c=word.charAt(0);
            if (c=='.'){
                for (char key:children.keySet()){
                    if (searchNode(word.substring(1), children.get(key))){
                        return true;
                    }
                }
                return false;
            }else if (children.containsKey(c)){
                t=children.get(c);
                return searchNode(word.substring(1), t);
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary w=new WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        System.out.println(w.search(".ad"));
    }
}
class TrieNode {
    char c;
    boolean isLeaf;
    Map<Character,TrieNode> children;
    TrieNode (char c){
        this.c=c;
        children=new HashMap<>();
    }
    TrieNode(){
        children=new HashMap<>();
    }
}
