package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数，写一个函数来判断它是否是2的幂。
 * @Date: Created in 下午4:07 2018/5/4
 * @Modified By:
 */
public class LeetCode231 {

    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        while (n>1){
            if((n&1)==1){
                return false;
            }
            n=n>>1;
        }
        return true;
    }
}
