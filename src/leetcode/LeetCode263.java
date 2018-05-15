package leetcode;

/**
 * @Author ROKG
 * @Description 编写一个程序判断给定的数是否为丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * @Date: Created in 下午2:22 2018/5/11
 * @Modified By:
 */
public class LeetCode263 {

    public boolean isUgly(int num) {
        if (num==0){
            return false;
        }
        while (num%2==0){
            num/=2;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%5==0){
            num/=5;
        }
        if (num==1){
            return true;
        }
        return false;
    }
}
