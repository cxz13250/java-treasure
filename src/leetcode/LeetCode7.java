package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * @Date: Created in 下午5:00 2018/4/13
 * @Modified By:
 */
public class LeetCode7 {

    public static int check(int x){
        int result=0;
        int temp=x;
        while (temp!=0){
            int num= temp%10;
            temp /=10;
            if(Math.abs(result)>Integer.MAX_VALUE/10){
                return 0;
            }
            if(Math.abs(result)==Integer.MAX_VALUE/10&&Math.abs(num)>Integer.MAX_VALUE%10){
                return 0;
            }
            result=result*10+num;
        }
        return result;
    }

    public static void main(String[] args) {
        int target=1534236469;
        System.out.println(check(target));
    }
}
