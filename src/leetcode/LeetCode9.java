package leetcode;

/**
 * @Author ROKG
 * @Description 判断回文数
 * @Date: Created in 下午4:54 2018/4/15
 * @Modified By:
 */
public class LeetCode9 {

    public static boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        int rem = 0,y = 0;
        int tmp = x;
        while (tmp !=0){
            rem = tmp % 10;
            y = y * 10 + rem;
            tmp = tmp / 10;
        }
        return x == y;
    }

    public static boolean isPalindrome2(int x){
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

    public static boolean isPalindrom3(int x){
        String s=String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        int x=121;
        System.out.println(isPalindrome(x));
    }
}
