package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * @Date: Created in 下午11:10 2018/6/2
 * @Modified By:
 */
public class LeetCode140 {

    List<String> result=new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list=new ArrayList<>();
        check(s,0,list,wordDict);
        return result;
    }

    public void check(String s,int start,List<String> strings,List<String> wordDict){
        if (start==s.length()){
            result.add(change(strings));
        }
        for (int j=start+1;j<=s.length();j++){
            String temp=s.substring(start,j);
            if (wordDict.contains(temp)){
                strings.add(temp);
                check(s,j,strings,wordDict);
                strings.remove(strings.size()-1);
            }
        }
    }

    public String change(List<String> strings){
        StringBuilder sb=new StringBuilder();
        for (String s:strings){
            if (sb.length()>0){
                sb.append(" ");
            }
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LeetCode140 l=new LeetCode140();
        List<String> list=new ArrayList<String>(){
            {
                add("cat");
                add("cats");
                add("and");
                add("sand");
                add("dog");
            }
        };
        System.out.println(l.wordBreak("catsanddog",list));
    }
}
