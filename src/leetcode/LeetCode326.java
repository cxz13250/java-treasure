package leetcode;

/**
 * @Author ROKG
 * @Description 给出一个整数，写一个函数来确定这个数是不是3的一个幂。
 * @Date: Created in 下午1:43 2018/5/11
 * @Modified By:
 */
public class LeetCode326 {

    public boolean isPowerOfThree(int n) {
        double temp=Math.log(n)/Math.log(3);
        double diff=Math.abs(temp-Math.round(temp));
        if (diff<=0.0000000001){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}
