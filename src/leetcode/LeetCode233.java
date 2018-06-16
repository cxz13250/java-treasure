package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * @Date: Created in 下午1:07 2018/6/2
 * @Modified By:
 */
public class LeetCode233 {

    public int countDigitOne(int n) {
        if (n<0){
            return 0;
        }
        int temp=1;
        int num=n;
        int count=0;
        while (num!=0){
            int rest=n-num*temp;
            int cur=num/10;
            int post=num%10;
            switch (post){
                case 0:
                    count+=cur*temp;
                    break;
                case 1:
                    count+=cur*temp+rest+1;
                    break;
                default:
                    count+=(cur+1)*temp;
            }
            temp*=10;
            num/=10;
        }
        return count;
    }
}
