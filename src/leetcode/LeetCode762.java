package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * @Date: Created in 下午9:27 2018/7/3
 * @Modified By:
 */
public class LeetCode762 {

    public int countPrimeSetBits(int L, int R) {
        int result=0;
        for (int i=L;i<=R;i++){
            String s=Integer.toBinaryString(i);
            int count=0;
            for (int j=0;j<s.length();j++){
                if (s.charAt(j)=='1'){
                    count++;
                }
            }
            if (check(count)){
                result++;
            }
        }
        return result;
    }

    public boolean check(int num){
        if (num==2){
            return true;
        }
        if (num<2 || num%2==0){
            return false;
        }
        for (int i=3;i<=Math.sqrt(num);i+=2){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
