package leetcode;

/**
 * @Author ROKG
 * @Description 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数
 * @Date: Created in 下午2:53 2018/5/2
 * @Modified By:
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        int sum=0;
        for(int i=0;i<32;i++){
            int temp=n&1;
            if(temp==1){
                sum++;
            }
            n=n>>1;
        }
        return sum;
    }
}
