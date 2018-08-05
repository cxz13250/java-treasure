package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * @Date: Created in 下午12:59 2018/8/5
 * @Modified By:
 */
public class LeetCode516 {

    public int longestPalindromeSubseq(String s) {
        int[][] res=new int[s.length()][s.length()];
        for (int i=s.length()-1;i>=0;i--){
            res[i][i]=1;
            for (int j=i+1;j<s.length();j++){
                if (s.charAt(i)==s.charAt(j)){
                    res[i][j]=res[i+1][j-1]+2;
                }else {
                    res[i][j]=Math.max(res[i+1][j],res[i][j-1]);
                }
            }
        }
        return res[0][s.length()-1];
    }
}
