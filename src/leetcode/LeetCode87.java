package leetcode;

/**
 * @Author ROKG
 * @Description 扰乱字符串
 * @Date: Created in 上午12:04 2018/8/24
 * @Modified By: *
 */
public class LeetCode87 {

    // res[i][j][len]表示以i和j为s1和s2的起点长度为len的字符串是否为扰乱字符串
    // 在某位置切开s1，则s1左侧与s2左侧相同数量的子串为Scramble String，并且s1右侧与s2右侧相同数量的子串为Scramble String；
    // 或者s1左侧与s2右侧相同数量的子串为Scramble String，并且s1右侧与s2左侧相同数量的子串为Scramble String。
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null){
            return true;
        }
        boolean[][][] res=new boolean[s1.length()][s2.length()][s1.length()+1];
        for(int i = 0; i < s1.length(); ++ i) {
            for (int j = 0; j < s2.length(); ++j) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len=2;len<=s1.length();len++){
            for (int i=0;i<s1.length()-len+1;i++){
                for (int j=0;j<s2.length()-len+1;j++){
                    for (int k=1;k<len;k++) {
                        res[i][j][len] = res[i][j][len] || res[i][j][k] && res[i+k][j+k][len-k] || res[i][j+len-k][k] && res[i+k][j][len-k];
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great","rgeat"));
    }
}
