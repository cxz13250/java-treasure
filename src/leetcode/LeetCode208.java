package leetcode;

import java.util.HashMap;

/**
 * @Author ROKG
 * @Description 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * @Date: Created in 下午2:14 2018/5/27
 * @Modified By: *
 */
public class LeetCode208 {

    static class Trie {

        boolean isTrie;

        HashMap<Character, Trie> children;

        /** Initialize your data structure here. */
        public Trie() {
            children=new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word==null||"".equals(word)){
                return;
            }
            char[] cc=word.toCharArray();
            int i=0;
            Trie t=this;
            while (i<cc.length){
                if (!t.children.containsKey(cc[i])){
                    t.children.put(cc[i],new Trie());
                }
                t=t.children.get(cc[i]);
                i++;
            }
            if (t.children.size()==0){
                t.isTrie=true;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word==null||"".equals(word)){
                return false;
            }
            char[] cc=word.toCharArray();
            int i=0;
            Trie t=this;
            while (i<cc.length){
                if (!t.children.containsKey(cc[i])){
                    return false;
                }
                t=t.children.get(cc[i]);
                i++;
            }
            return t.isTrie;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix==null||"".equals(prefix)){
                return false;
            }
            char[] cc=prefix.toCharArray();
            int i=0;
            Trie t=this;
            while (i<cc.length){
                if (!t.children.containsKey(cc[i])){
                    return false;
                }
                t=t.children.get(cc[i]);
                i++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        Trie t=new Trie();
//        t.insert("a");
//        System.out.println(t.search("a"));
//        System.out.println(t.startsWith("a"));
    }

}
