package leetcode;

/**
 * @Author ROKG
 * @Description 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * @Date: Created in 下午12:31 2018/5/10
 * @Modified By: *
 */
public class LeetCode400 {

    public static int findNthDigit(int n) {
        int len=1; //位数
        long count=9; //当前位数数字的个数
        int start=1; //当前位数第一个数
        while (n>len*count){
            n-=len*count;
            len++;
            count*=10;
            start*=10;
        }
        return Integer.toString(start+(n-1)/len).charAt((n-1)%len)-'0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
    }
}
