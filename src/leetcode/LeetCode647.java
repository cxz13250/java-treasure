package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * @Date: Created in 下午11:13 2018/8/12
 * @Modified By:
 */
public class LeetCode647 {

    int sum = 0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            count(s,i,i);
            count(s,i,i+1);
        }
        return sum;
    }
    public void count(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            sum++;
        }
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int[] dp = new int[s.length()];
        int cnt=0;
        for (int i=0;i<s.length();i++){
            dp[i]=1;
            cnt++;
            for (int j=0;j<i;j++){
                if (s.charAt(i)==s.charAt(j)&&dp[j+1]==1){
                    dp[j]=1;
                    cnt++;
                }else {
                    dp[j]=0;
                }
            }
        }
        return cnt;
    }
}
