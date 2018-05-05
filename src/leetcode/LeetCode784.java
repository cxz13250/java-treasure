package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @Date: Created in 下午10:24 2018/5/2
 * @Modified By:
 */
public class LeetCode784 {

    List<String> result=new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        int i=0;
        check(S,i);
        return result;
    }

    public void check(String str,int i){
        if(i==str.length()){
            result.add(str);
        }else {
            while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                i++;
            }
            if(i==str.length()){
                result.add(str);
                return;
            }
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                check(str,i+1);
                StringBuilder sb=new StringBuilder(str);
                sb.replace(i,i+1,String.valueOf(Character.toUpperCase(str.charAt(i))));
                check(sb.toString(),i+1);
            }else {
                StringBuilder sb=new StringBuilder(str);
                sb.replace(i,i+1,String.valueOf(Character.toLowerCase(str.charAt(i))));
                check(sb.toString(),i+1);
                check(str,i+1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode784 t=new LeetCode784();
        System.out.println(t.letterCasePermutation("a1b2"));
    }
}
