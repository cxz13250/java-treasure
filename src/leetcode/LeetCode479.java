package leetcode;

/**
 * @Author ROKG
 * @Description 你需要找到由两个 n 位数的乘积组成的最大回文数。由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
 * @Date: Created in 下午8:30 2018/5/16
 * @Modified By:
 */
public class LeetCode479 {

    public int largestPalindrome(int n) {
        if(n == 1)
            return 9;
        int upper = (int)Math.pow(10,n)-1;
        for(int i = upper; i>upper/10; i--){
            long palin = toPalindrome(i);
            for(int j = upper; j>upper/10; j--){
                if(palin / j > upper)
                    break;
                if(palin % j == 0)
                    return (int)(palin % 1337);
            }
        }
        return -1;
    }
    public long toPalindrome(int i){
        StringBuffer str = new StringBuffer();
        str.append(i+"");
        String a = str.reverse().toString();
        return Long.parseLong(i+""+a);
    }
}
