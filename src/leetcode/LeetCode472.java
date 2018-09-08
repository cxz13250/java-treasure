package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。
 *连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
 * @Date: Created in 下午2:14 2018/9/8
 * @Modified By: *
 */
public class LeetCode472 {

    // 先对words按长度从小到大排序
    // 遍历words，一次检验每个字符串是否合格，转化为子问题
    // 检验过程通过动态规划，长度为i的字符串是否合格就看其前j个字符子串（j取[0~i))是否合格并且从j到i子串在不在字典集里，存在则合格
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res=new ArrayList<>();
        if (words.length<=1){
            return res;
        }
        Arrays.sort(words, Comparator.comparingInt(v -> v.length()));
        Set<String> set=new HashSet<>();
        for (String s:words){
            if (isValid(set,s)){
                res.add(s);
            }
            set.add(s);
        }
        return res;
    }

    public boolean isValid(Set<String> set,String s){
        if (set.isEmpty()){
            return false;
        }
        boolean res[]=new boolean[s.length()+1];
        res[0]=true;
        for (int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (res[j]&&set.contains(s.substring(j,i))){
                    res[i]=true;
                    break;
                }
            }
        }
        return res[s.length()];
    }

    public static void main(String[] args) {
        LeetCode472 l=new LeetCode472();
        System.out.println(l.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }
}
