package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * @Date: Created in 下午11:36 2018/8/18
 * @Modified By: *
 */
public class LeetCode583 {

    // res[i][j]表示word1前i位和word2前j位中最大相同子序列的长度
    // word1第i位和word2第j位相同时，就等于word1前i-1位和word2前j-1位最大相同子序列的长度+1
    public static int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        int[][] res=new int[len1+1][len2+1];
        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    res[i][j]=res[i-1][j-1]+1;
                }else {
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1]);
                }
            }
        }
        return len1+len2-2*res[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("kitten","sitting"));
    }
}
