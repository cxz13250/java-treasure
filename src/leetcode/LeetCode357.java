package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n。
 * @Date: Created in 下午4:16 2018/6/10
 * @Modified By:
 */
public class LeetCode357 {

    public static int countNumbersWithUniqueDigits(int n) {
        if (n==0){
            return 1;
        }
        int count=10;
        for (int i=2;i<=n;i++){
            int level=i;
            int temp=9;
            int num=9;
            while (level>1){
                temp*=num;
                num--;
                level--;
            }
            count+=temp;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
