package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * @Date: Created in 下午2:14 2018/5/17
 * @Modified By:
 */
public class LeetCode454 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result=0;
        Map<Integer,Integer> map =new HashMap<>();
        for (int k=0;k<C.length;k++){
            for (int l=0;l<D.length;l++){
                map.put(C[k]+D[l],map.getOrDefault(C[k]+D[l],0)+1);
            }
        }
        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++){
                result+=map.getOrDefault(-A[i]-B[j],0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A={1,2};
        int[] B={-2,-1};
        int[] C={-1,2};
        int[] D={0,2};
        System.out.println(fourSumCount(A,B,C,D));
    }
}
