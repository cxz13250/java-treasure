package leetcode;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * @Date: Created in 下午10:55 2018/4/23
 * @Modified By: *
 */
public class LeetCode30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return result;
        }
        Map<String,Integer> map=new HashMap<>();
        for (String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int wordsCount=words.length;
        int wordLength=words[0].length();
        Map<String,Integer> cur=new HashMap<>();
        for (int i=0;i<=s.length()-wordLength*wordsCount;i++){
            cur.clear();
            int j=0;
            for (;j<wordsCount;j++){
                int temp=i+j*wordLength;
                String sub=s.substring(temp,temp+wordLength);
                if (!map.containsKey(sub)){
                    break;
                }
                cur.put(sub,cur.getOrDefault(sub,0)+1);
                if (cur.get(sub)>map.get(sub)){
                    break;
                }
            }
            if (j==wordsCount){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat time=new SimpleDateFormat("yyyy MM dd");
        System.out.println(time.format(date));
        String[] s={"foo","bar"};
        System.out.println(findSubstring("barfoothefoobarman",s));
    }
}
