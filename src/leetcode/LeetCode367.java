package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * @Date: Created in 下午3:11 2018/5/5
 * @Modified By:
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {
        if (num==1){
            return true;
        }
        for (int i=1;i<=num/2;i++){
            if(i*i==num){
                return true;
            }
        }
        return false;
    }
}
