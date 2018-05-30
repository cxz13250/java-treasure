package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回符合要求的最少分割次数。
 * @Date: Created in 下午7:59 2018/5/29
 * @Modified By: *
 */
public class LeetCode132 {

    /*状态转移方程：dp[i][j]=s.charAt(i)==s.charAt(j)&&(i<=j+1||dp[i+1][j-1]==1)
    result[i]表示从i到结尾最少需要切几次可全部变成回文子串
    */
    public int minCut(String s) {
        int result[]=new int[s.length()+1];
        int dp[][]=new int[s.length()][s.length()];
        for (int i=s.length()-1;i>=0;i--){
            result[i]=Integer.MAX_VALUE;
            for (int j=i;j<s.length();j++){
                if (s.charAt(i)==s.charAt(j)&&(j<=i+1||dp[i+1][j-1]==1)){
                    dp[i][j]=1;
                    result[i]=Math.min(result[j+1]+1,result[i]);
                }
            }
        }
        return result[0]-1;
    }

    public static void main(String[] args) {
        LeetCode132 l=new LeetCode132();
        System.out.println(l.minCut("efe"));
    }
}
