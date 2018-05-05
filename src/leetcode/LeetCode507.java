package leetcode;

/**
 * @Author ROKG
 * @Description 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 * @Date: Created in 下午5:18 2018/5/3
 * @Modified By:
 */
public class LeetCode507 {

    public static boolean checkPerfectNumber(int num) {
        if(num == 1) {
            return false;
        }
        int result=0;
        for (int i=2;i<=(int)Math.sqrt(num);i++){
            if (num%i==0){
                result+=i;
                result+=num/i;
            }
            if (result>num){
                return false;
            }
        }
        return result==num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
    }
}
