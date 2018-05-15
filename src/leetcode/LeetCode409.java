package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:55 2018/5/12
 * @Modified By:
 */
public class LeetCode409 {

    public static int longestPalindrome(String s) {
        int result=0;
        int[] num=new int[128];
        for (int i=0;i<s.length();i++){
            num[s.charAt(i)]++;
        }
        for (int i=0;i<num.length;i++){
            if (num[i]!=0&&num[i]%2==0){
                result+=num[i];
            }
            if (num[i]!=0&&num[i]%2==1){
                result+=num[i]-1;
            }
        }
        return result>=s.length()?result:result+1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
