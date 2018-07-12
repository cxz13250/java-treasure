package leetcode;

import java.util.HashSet;
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

    class WordDictionary {

        Set<String> set;

        /** Initialize your data structure here. */
        public WordDictionary() {
            set=new HashSet<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            set.add(word);

        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return set.contains(word);
        }
    }
}
