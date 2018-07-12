package leetcode;

/**
 * @Author ROKG
 * @Description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * @Date: Created in 下午11:30 2018/7/12
 * @Modified By:
 */
public class LeetCode392 {

    public static boolean isSubsequence(String s, String t) {
        if (s.length()>t.length()){
            return false;
        }
        int last=0;
        for (int i=0;i<s.length();i++){
            int temp=t.substring(last,t.length()).indexOf(s.charAt(i));
            if (temp==-1){
                return false;
            }else{
                last=temp+last+1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb","ahbgdc"));
    }
}
