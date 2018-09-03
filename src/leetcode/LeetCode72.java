package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * @Date: Created in 2018/9/3
 * @Modified By: *
 */
public class LeetCode72 {

    // res[i][j]表示word1中前i个元素与word2中前j个元素的距离
    // res[i][j]取值有四种情况： res[i-1][j]+1
    // res[i][j-1]+1
    // res[i-1][j-1] word1第i个元素与word2第j个元素相同
    // res[i-1][j-1]+1 word1第i个元素与word2第j个元素不同
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] res=new int[m+1][n+1];
        for (int i=0;i<m+1;i++){
            res[i][0]=i;
        }
        for (int i=0;i<n+1;i++){
            res[0][i]=i;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                res[i][j]=Math.min(res[i-1][j-1]+(word1.charAt(i)==word2.charAt(j)?0:1), Math.min(res[i-1][j]+1,res[i][j-1]+1));
            }
        }
        return res[m][n];
    }
}
