package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个长度为 n 的整数数组 A 。假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 * @Date: Created in 下午11:45 2018/7/14
 * @Modified By: *
 */
public class LeetCode396 {

    public int maxRotateFunction(int[] A) {
        if (A.length==0){
            return 0;
        }
        int m=A.length;
        int result=Integer.MIN_VALUE;
        for (int i=0;i<m;i++){
            int temp=0;
            for (int j=0,k=i;j<m;j++,k++){
                temp+=(m+k)%m*A[j];
            }
            result=Math.max(temp,result);
        }
        return result;
    }

    public int maxRotateFunction2(int[] A) {
       long result=Integer.MIN_VALUE;
       long cur=0;
       long total=0;
       for (int i=0;i<A.length;i++){
           cur+=i*A[i];
           total+=A[i];
       }
       result=Math.max(result,cur);
       for (int i=A.length-1;i>=0;i--){
           cur+=total-A.length*A[i];
           result=Math.max(cur,result);
       }
       return (int)result;
    }
}
