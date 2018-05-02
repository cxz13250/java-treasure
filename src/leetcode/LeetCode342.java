package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数 (32位有符整数型)，请写出一个函数来检验它是否是4的幂。
 * @Date: Created in 下午11:59 2018/4/29
 * @Modified By:
 */
public class LeetCode342 {

    public static boolean isPowerOfFour(int num) {
        if(num==1){
            return true;
        }
        if(num<=0){
            return false;
        }
        while (num>0){
            if(num==1){
                break;
            }
            if(num%4==0) {
                num = num / 4;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-2147483648));
    }
}
