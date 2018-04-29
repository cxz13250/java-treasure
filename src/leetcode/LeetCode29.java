package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。返回被除数 dividend 除以除数 divisor 得到的商。
 * @Date: Created in 下午10:29 2018/4/22
 * @Modified By:
 */
public class LeetCode29 {

    public static int divide(int dividend, int divisor) {
        long result=0;
        int flag=1;
        if(dividend<0){
            flag=-flag;
        }
        if(divisor<0){
            flag=-flag;
        }
        long num1=Math.abs((long)dividend);
        long num2=Math.abs((long)divisor);
        while (num1>=num2){
            long temp=num2;
            int count=0;
            while (temp<=num1){
                temp <<= 1;
                count++;
            }
            result+=(long)1<<(count-1);
            num1=num1-(num2<<(count-1));
        }
        if (flag==1&result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (flag==-1&result>Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result*flag;
    }

    public static void main(String[] args) {
        System.out.println(divide(-1010369383, -2147483648));
    }
}
