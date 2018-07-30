package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * @Date: Created in 2018/7/27
 * @Modified By:
 */
public class LeetCode500 {

    List<String> dict=new ArrayList<String>(){
        {
            add("qwertyuiopQWERTYUIOP");
            add("asdafghjklASDFGHJKL");
            add("zxcvbnmZXCVBNM");
        }
    };

    public String[] findWords(String[] words) {
        List<String> list=new ArrayList<>();
        for (String s:words){
            char c=s.charAt(0);
            String compare="";
            for (String d:dict){
                if (d.indexOf(c)>-1){
                    compare=d;
                }
            }
            boolean config=true;
            for (int i=1;i<s.length();i++){
                if (compare.indexOf(s.charAt(i))<0){
                    config=false;
                    break;
                }
            }
            if (config) {
                list.add(s);
            }
        }
        String[] result=new String[list.size()];
        for (int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
