package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * @Date: Created in 2018/8/7
 * @Modified By:
 */
public class LeetCode524 {

    public String findLongestWord(String s, List<String> d) {
        int max=-1;
        String res="";
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    return o1.length()-o2.length();
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (String str:d){
            if (check(s,str)&&str.length()>max){
                max = str.length();
                res = str;
            }
        }
        return res;
    }

    public boolean check(String s, String d){
        int i=0;
        for (char c:s.toCharArray()){
            if (d.charAt(i)==c){
                i++;
            }
            if (i==d.length()){
                break;
            }
        }
        return i==d.length();
    }

    public static void main(String[] args) {
        String s1="foo";
        String s2="bar";
        System.out.println(s1.compareTo(s2));
    }
}
