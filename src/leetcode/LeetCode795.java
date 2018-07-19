package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * @Date: Created in 下午10:08 2018/7/2
 * @Modified By: *
 */
public class LeetCode795 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result=0;
        int left=-1;
        int right=-1;
        for (int i=0;i<A.length;i++){
            if (A[i]>R){
                left=i;
                right=i;
            }else if (A[i]<L){
                result+=(i-left)-(i-right);
            }else {
                result+=(i-left);
                right=i;
            }
        }
        return result;
    }
}
