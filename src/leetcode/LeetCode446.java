package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 求一个数列中等差子数列（不连续）的数量
 * @Date: Created in 2018/9/13
 * @Modified By:  *
 */
public class LeetCode446 {

    // 对每个元素i，用一个map来储存所有包含它的等差子序列并且记录每个差值
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length==0){
            return 0;
        }
        int res=0;
        Map<Integer, Integer>[] maps=new HashMap[A.length];
        for (int i=0;i<A.length;i++){
            maps[i]=new HashMap<>();
        }
        for (int i=0;i<A.length;i++){
            for (int j=0;j<i;j++){
                int diff=A[i]-A[j];
                if ((long) A[i] - (long)A[j] >= Integer.MAX_VALUE || (long) A[i] - (long)A[j] <= Integer.MIN_VALUE) {
                    continue;
                }
                maps[i].put(diff, maps[i].getOrDefault(diff, 0)+1);
                if (maps[j].getOrDefault(diff, 0)>0){
                    maps[i].put(diff, maps[i].get(diff)+maps[j].get(diff));
                    res+=maps[j].get(diff);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
    }
}
