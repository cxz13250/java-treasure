package leetcode;

/**
 * @Author ROKG
 * @Description 颠倒给定的 32 位无符号整数的二进制位。
 * @Date: Created in 下午2:02 2018/5/1
 * @Modified By:
 */
public class LeetCode190 {

    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            result=(result<<1);
            result+=(n&1);
            n=n>>1;
        }
        return result;
    }
}
