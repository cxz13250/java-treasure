package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 n，你可以做如下操作：
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 * @Date: Created in 下午7:56 2018/5/22
 * @Modified By:
 */
public class LeetCode397 {

    public static int integerReplacement(int n) {
        if (n==0 || n==1){
            return 0;
        }
        if (n==3){
            return 2;
        }
        if ((n&1)==0){
            return 1+integerReplacement(n>>>1);
        }else {
            return Math.min(1+integerReplacement(n+1),1+integerReplacement(n-1));
        }
    }

    public static int integerReplacement2(int n) {
        int count=0;
        long num=n;
        while (num>1){
            if (num==3){
                count+=2;
                break;
            }
            if ((num&1)==0){
                num=num>>>1;
            }else if (((num>>>1)&1)==1){
                num++;
            }else {
                num--;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(2147483647));
        System.out.println(integerReplacement2(2147483647));
    }
}
