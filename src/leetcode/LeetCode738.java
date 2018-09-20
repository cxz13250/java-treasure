package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * @Date: Created in 2018/9/20
 * @Modified By: *
 */
public class LeetCode738 {

    // 当cc[i-1]>cc[i]，只需要把cc[i-1]减1，cc[i]置为9即可，所以从后往前找最后一个不符合单调增的位置
    public static int monotoneIncreasingDigits(int N) {
        String s=String.valueOf(N);
        char[] cc=s.toCharArray();
        int start=cc.length;
        for (int i=cc.length-1;i>=1;i--){
            if (cc[i]>=cc[i-1]){
                continue;
            }else {
                cc[i-1]--;
                start=i;
            }
        }
        for (int i=start;i<s.length();i++){
            cc[i]='9';
        }
        return Integer.valueOf(String.valueOf(cc));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }
}
