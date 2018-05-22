package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * @Date: Created in 下午6:34 2018/5/19
 * @Modified By:
 */
public class LeetCode693 {

    public boolean hasAlternatingBits(int n) {
        String s=Integer.toBinaryString(n);
        for (int i=0;i<s.length()-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}
