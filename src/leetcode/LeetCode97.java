package leetcode;

/**
 * @Author ROKG
 * @Description 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * @Date: Created in 下午12:28 2018/7/29
 * @Modified By:
 */
public class LeetCode97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3==null){
            return false;
        }
        if ((s1.length()+s2.length())!=s3.length()){
            return false;
        }
        return check(s1,s2,s3,0,0,0);
    }

    public boolean check(String s1, String s2, String s3,int i1,int i2,int i3){
        if (i3==s3.length()){
            return true;
        }
        if (i1<s1.length()&&i2<s2.length()) {
            char c1 = s1.charAt(i1);
            char c2 = s2.charAt(i2);
            char c3 = s3.charAt(i3);
            if (c1 != c3 && c2 != c3) {
                return false;
            } else if (c1 == c3 && c2!=c3){
                return check(s1,s2,s3,i1+1,i2,i3+1);
            } else if (c2 == c3 && c1!=c3){
                return check(s1,s2,s3,i1,i2+1,i3+1);
            } else {
                return check(s1,s2,s3,i1+1,i2,i3+1) || check(s1,s2,s3,i1,i2+1,i3+1);
            }
        }else if (i1<s1.length()){
            char c1 = s1.charAt(i1);
            char c3 = s3.charAt(i3);
            if (c1!=c3){
                return false;
            }else {
                return check(s1,s2,s3,i1+1,i2,i3+1);
            }
        }else {
            char c2 = s2.charAt(i2);
            char c3 = s3.charAt(i3);
            if (c2!=c3){
                return false;
            }else {
                return check(s1,s2,s3,i1,i2+1,i3+1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode97 l=new LeetCode97();
        System.out.println(l.isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"));
    }
}
