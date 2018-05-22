package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * @Date: Created in 下午8:53 2018/5/20
 * @Modified By:
 */
public class LeetCode720 {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set=new HashSet<>();
        String res="";
        for (String s:words){
            if (s.length()==0 || set.contains(s.substring(0,s.length()-1))){
                res=res.length()>=s.length()?res:s;
                set.add(s);
            }
        }
        return res;
    }

    public String longestWord2(String[] words) {
        Set<String> set=new HashSet<String>();
        for(int i=0;i<words.length;i++){
            set.add(words[i]);
        }
        int length=0;
        String word="";
        for(int i=0;i<words.length;i++){
            if(words[i].length()>length||(words[i].length()==length&&words[i].compareTo(word)<0)){
                int len=words[i].length();
                while(len>0&&set.contains(words[i].substring(0,len))){
                    len--;
                }
                if(len==0){
                    length=words[i].length();
                    word=words[i];
                }
            }
        }
        return word;
    }
}
