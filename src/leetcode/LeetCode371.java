package leetcode;

/**
 * @Author ROKG
 * @Description 不使用运算符 + 和-，计算两整数a 、b之和。
 * @Date: Created in 下午11:33 2018/4/25
 * @Modified By:
 */
public class LeetCode371 {

    public int getSum(int a, int b) {
        if(b==0){
            return a;
        }else{
            return getSum(a&b,a^b >> 1);
        }
    }
}
