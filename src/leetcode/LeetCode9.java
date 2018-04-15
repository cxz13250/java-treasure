package leetcode;

/**
 * @Author ROKG
 * @Description 判断回文数
 * @Date: Created in 下午4:54 2018/4/15
 * @Modified By:
 */
public class LeetCode9 {

    public static boolean isPalindrome(int x){
        String s=String.valueOf(x);
        int temp=s.length()/2;
        if(s.length()%2==0){
            return checkPalindromeExpand(s,temp-1,temp);
        }else {
            return checkPalindromeExpand(s,temp,temp);
        }
    }

    public static boolean checkPalindromeExpand(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) == s.charAt(high)) {
                low--; high++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x=10;
        System.out.println(isPalindrome(x));
    }
}
