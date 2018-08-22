package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 * @Date: Created in 上午12:00 2018/8/16
 * @Modified By:
 */
public class LeetCode888 {

    public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mapA=new HashMap<>();
        Map<String, Integer> mapB=new HashMap<>();
        String[] sA=A.split(" ");
        String[] sB=B.split(" ");
        List<String> res=new ArrayList<>();
        for (String s:sA){
            mapA.put(s,mapA.getOrDefault(s,0)+1);
        }
        for (String s:sB){
            mapB.put(s,mapB.getOrDefault(s,0)+1);
        }
        for (String s:mapA.keySet()){
            if (mapA.get(s)==1&&!mapB.containsKey(s)){
                res.add(s);
            }
        }
        for (String s:mapB.keySet()){
            if (mapB.get(s)==1&&!mapA.containsKey(s)){
                res.add(s);
            }
        }
        String[] ss=new String[res.size()];
        for (int i=0;i<ss.length;i++){
            ss[i]=res.get(i);
        }
        return ss;
    }

    public static void main(String[] args) {
        System.out.println(uncommonFromSentences("this apple is sweet","this apple is sour"));
    }
}
