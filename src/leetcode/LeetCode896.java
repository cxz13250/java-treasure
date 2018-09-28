package leetcode;

/**
 * @Author ROKG
 * @Description 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * @Date: Created in 2018/9/28
 * @Modified By:
 */
public class LeetCode896 {

    public static boolean isMonotonic(int[] A) {
        int flag=-1;
        for (int i=0;i<A.length-1;i++){
            if (flag==-1){
                if (A[i] < A[i+1]) {
                    flag=1;  // 递增
                }else if (A[i]>A[i+1]) {
                    flag=0;  // 递减
                }
            }else {
                if ((flag==1&&A[i]>A[i+1])||(flag==0&&A[i]<A[i+1])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
