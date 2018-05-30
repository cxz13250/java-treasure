package leetcode;

/**
 * @Author ROKG
 * @Description 假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * @Date: Created in 下午4:21 2018/5/26
 * @Modified By: *
 */
public class LeetCode474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int result[][]=new int[m+1][n+1];

        for (String str:strs){
            int count0=0;
            int count1=0;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)=='1'){
                    count1++;
                }else {
                    count0++;
                }
            }

            for (int i=m;i>=count0;i--){
                for (int j=n;j>=count1;j--){
                    result[i][j]=Math.max(result[i][j],1+result[i-count0][j-count1]);
                }
            }
        }
        return result[m][n];
    }


    public static void main(String[] args) {
    }
}
