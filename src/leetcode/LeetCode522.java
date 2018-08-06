package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ROKG
 * @Description 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 * @Date: Created in 2018/8/6
 * @Modified By:
 */
public class LeetCode522 {

    public static int findLUSlength(String[] strs) {
        int res=-1;
        for (int i=0;i<strs.length;i++){
            int j=0;
            for (;j<strs.length;j++){
                if (i!=j){
                    if (check(strs[i],strs[j])){
                        break;
                    }
                }
            }
            if (j==strs.length){
                res=Math.max(res,strs[i].length());
            }
        }
        return res;
    }

    public static boolean check(String s1,String s2){
        int i=0;
        for (char c:s2.toCharArray()){
            if (c==s1.charAt(i)){
                i++;
            }
            if (i==s1.length()){
                break;
            }
        }
        return i==s1.length();
    }

    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae"}));
    }
}
