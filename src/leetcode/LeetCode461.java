package leetcode;

/**
 * @Author ROKG
 * @Description 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。给出两个整数 x 和 y，计算它们之间的汉明距离。
 * @Date: Created in 下午12:10 2018/5/4
 * @Modified By:
 */
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int temp=x^y;
        int result=0;
        String s=Integer.toBinaryString(temp);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                result++;
            }
        }
        return result;
    }
}
