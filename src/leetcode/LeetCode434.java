package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ROKG
 * @Description 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。请注意，你可以假定字符串里不包括任何不可打印的字符。
 * @Date: Created in 下午2:51 2018/5/3
 * @Modified By:
 */
public class LeetCode434 {

    public static int countSegments(String s) {
        if(s.equals("")){
            return 0;
        }
        String[] strings=s.split(" ");
        List<String> list=Arrays.asList(strings);
        return (int)list.stream().filter(s1-> !s1.equals("")).count();
    }

    public static void main(String[] args) {
        String s=", , , ,        a, eaefa";
        System.out.println(countSegments(s));
    }
}
