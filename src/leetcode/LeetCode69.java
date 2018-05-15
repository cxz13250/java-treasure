package leetcode;

/**
 * @Author ROKG
 * @Description 实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
 * @Date: Created in 上午12:14 2018/5/15
 * @Modified By: *
 */
public class LeetCode69 {

    public static int mySqrt(int x) {
        if (x==0||x==1){
            return x;
        }
        int left=1;
        int right=x-1;
        int mid=left+(right-left)/2;
        while (left<=right){
            mid=left+(right-left)/2;
            if (x/mid==mid){
                return mid;
            }else if (x/mid<mid){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        if (mid>x/mid){
            return mid-1;
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
