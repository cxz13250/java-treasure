package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * @Date: Created in 下午10:32 2018/5/8
 * @Modified By: *
 */
public class LeetCode139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        boolean[] result=new boolean[s.length()+1];
        result[0]=true;
        for (int i=1;i<s.length()+1;i++){
            for (int j=0;j<i;j++){
                String temp=s.substring(j,i);
                if (result[j]&&wordDict.contains(temp)){
                    result[i]=true;
                    break;
                }
            }
        }
        return result[s.length()-1];
    }

    public static void main(String[] args) {
        List<String> wordDict=new ArrayList<String>(){
            {
                add("leet");
                add("code");
            }
        };
        System.out.println(wordBreak("leetcode",wordDict));
    }
}
