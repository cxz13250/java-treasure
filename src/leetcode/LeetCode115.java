package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * @Date: Created in 下午9:16 2018/5/25
 * @Modified By:
 */
public class LeetCode115 {

    //动态规划
    public int numDistinct2(String s, String t) {
        int[][] result=new int[s.length()+1][t.length()+1];
        for (int i=0;i<=s.length();i++){
            result[i][0]=1;
        }
        for (int j=1;j<=t.length();j++){
            for (int i=1;i<=s.length();i++){
                result[i][j]=result[i-1][j];
                if (s.charAt(i-1)==t.charAt(j-1)){
                    result[i][j]+=result[i-1][j-1];
                }
            }
        }
        return result[s.length()][t.length()];
    }

    int result=0;

    //递归，超时
    public int numDistinct(String s, String t) {
        StringBuilder sb=new StringBuilder();
        check(s,t,0,0,sb);
        return result;
    }

    public void check(String s,String t,int i,int j,StringBuilder sb){
        if (j==t.length()){
            if (sb.toString().equals(t)){
                result++;
                return;
            }
        }
        if (i>s.length()-t.length()+j){
            return;
        }
        while (i<s.length()){
            if (s.charAt(i)==t.charAt(j)){
                sb.append(s.charAt(i));
                check(s,t,i+1,j+1,sb);
                sb.deleteCharAt(j);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        String s1="rabbbit";
        String t1="rabbit";
        String s2="babgbag";
        String t2="bag";
        LeetCode115 l=new LeetCode115();
        System.out.println(l.numDistinct2(s1,t1));
        System.out.println(l.numDistinct2(s2,t2));
    }
}
