package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * @Date: Created in 下午2:36 2018/5/10
 * @Modified By:
 */
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        if (c==0){
            return true;
        }
        int temp=(int)Math.sqrt(c);
        for (int i=1;i<=temp;i++){
            int a=i;
            int b=(int)Math.sqrt(c-a*a);
            if (a*a+b*b==c){
                return true;
            }
        }
        return false;
    }
}
