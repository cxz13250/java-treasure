package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * @Date: Created in 上午12:04 2018/7/25
 * @Modified By:
 */
public class LeetCode819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] strs=paragraph.split(" ");
        Map<String,Integer> map=new HashMap<>();
        int max=0;
        for (int i=0;i<strs.length;i++){
            String temp=strs[i];
            char c=temp.charAt(temp.length()-1);
            if (c==','||c=='.'||c=='?'||c=='!'||c=='\''||c==';'){
                temp=temp.substring(0,temp.length()-1);
            }
            temp=temp.toLowerCase();
            if (check(temp,banned)){
                map.put(temp,map.getOrDefault(temp,0)+1);
                max=Math.max(max,map.get(temp));
            }
        }
        for (String s:map.keySet()){
            if (map.get(s)==max){
                return s;
            }
        }
        return "";
    }

    public boolean check(String s,String[] banned){
        for (String str:banned){
            if (str.equals(s)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode819 l=new LeetCode819();
        String s="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] ss={"hit"};
        System.out.println(l.mostCommonWord(s,ss));
    }
}
