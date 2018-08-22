package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * @Date: Created in 2018/8/22
 * @Modified By: *
 */
public class LeetCode712 {

    // res[i][j]表示s1中0~i这段字符串与s2中0~j这段字符串需删除字符的最小ASCII码之和
    public static int minimumDeleteSum(String s1, String s2) {
        int m= s1.length(),n=s2.length();
        int[][] res=new int[m+1][n+1];
        for (int i=1;i<m+1;i++){
            res[i][0]=res[i-1][0]+s1.charAt(i-1);
        }
        for (int i=1;i<n+1;i++){
            res[0][i]=res[0][i-1]+s2.charAt(i-1);
        }
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    res[i][j]=res[i-1][j-1];
                }else {
                    res[i][j]=Math.min(res[i-1][j]+s1.charAt(i-1), res[i][j-1]+s2.charAt(j-1));
                }
            }
        }
        return res[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("ccaccjp","fwosarcwge"));
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
