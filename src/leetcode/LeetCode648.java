package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 * @Date: Created in 上午11:26 2018/9/15
 * @Modified By:
 */
public class LeetCode648 {

    public static String replaceWords(List<String> dict, String sentence) {
        String[] strings=sentence.split(" ");
        boolean[] flag=new boolean[26];
        for (String d:dict){
            flag[d.charAt(0)-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<strings.length;i++){
            String temp=strings[i];
            if (!flag[temp.charAt(0)-'a']){
                sb.append(temp+" ");
                continue;
            }
            boolean has=false;
            for (int j=1;j<=strings[i].length();j++){
                if (dict.contains(strings[i].substring(0,j))){
                    sb.append(strings[i].substring(0,j)+" ");
                    has=true;
                    break;
                }
            }
            if (!has){
                sb.append(temp+" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>(){
            {
                add("cat");
                add("rat");
                add("bat");
            }
        };
        System.out.println(replaceWords(list,"the cattle was rattled by the batter"));
    }
}
