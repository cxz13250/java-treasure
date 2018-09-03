package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * @Date: Created in 2018/7/16
 * @Modified By: *
 */
public class LeetCode44 {

    // res[i][j]表示p前i个元素与s前j个元素是否匹配
    // 在位置i,j处,如果p第i个元素为*，则位置i,j-1和i-1,j-1和i-1,j只要有一个能匹配,i,j就能匹配
    // 如果p第i个元素为?或者与s第j个元素相同,并且i-1,j-1能匹配,i,j就能匹配
    public static boolean isMatch(String s, String p) {
        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        int m=s.length(),n=p.length();
        boolean[][] res=new boolean[n+1][m+1];
        res[0][0]=true;
        int start=0;
        for (int i=1;i<=n;i++){
            if (pp[i-1]=='*'){
                res[i][0]=res[i-1][0];
                for (int j=1;j<=m;j++){
                    res[i][j]=res[i-1][j]||res[i-1][j-1]||res[i][j-1];
                }
            }else {
                start++;
                for (int j=start;j<=m;j++){
                    if (pp[i-1]=='?'||pp[i-1]==ss[j-1]){
                        if (res[i-1][j-1]){
                            res[i][j]=true;
                        }
                    }
                }
            }
        }
        return res[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b"));
    }
}
