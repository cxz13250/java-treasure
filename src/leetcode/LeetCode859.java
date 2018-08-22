package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * @Date: Created in 下午10:54 2018/8/16
 * @Modified By:
 */
public class LeetCode859 {

    public static boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()){
            return false;
        }
        if (A.equals(B)){
            Set<Character> set=new HashSet<>();
            for (char c:A.toCharArray()){
                if (set.contains(c)){
                    return true;
                }else {
                    set.add(c);
                }
            }
            return false;
        }
        int count=0;
        int first=0,second=0;
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)!=B.charAt(i)){
                count++;
                if (count==1){
                    first=i;
                }else if (count==2){
                    second=i;
                }
                if (count>2){
                    return false;
                }
            }
        }
        if (count==1){
            return false;
        }
        if (count==2){
            return A.charAt(first)==B.charAt(second)&&A.charAt(second)==B.charAt(first);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab","ab"));
    }
}
