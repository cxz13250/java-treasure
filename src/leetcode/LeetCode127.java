package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * @Date: Created in 2018/9/11
 * @Modified By:
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null
                || beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length() || !wordList.contains(endWord)) {
            return 0 ;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 1;
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i=0; i<chs.length; i++) {
                    for (char c='a'; c<='z'; c++) {
                        if (c!=chs[i]) {
                            char old = chs[i];
                            chs[i] = c;
                            String target = String.valueOf(chs);

                            if (endSet.contains(target)) {
                                return len + 1;
                            }

                            if (!visited.contains(target) && wordList.contains(target)) {
                                temp.add(target);
                                visited.add(target);
                            }
                            chs[i] = old;
                        }
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode127 l=new LeetCode127();
        System.out.println(l.ladderLength("hit", "cog", new ArrayList<String>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }}));
    }
}
