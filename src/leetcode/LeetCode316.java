package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 编写一段程序来查找第 n 个超级丑数。超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * @Date: Created in 下午1:32 2018/6/10
 * @Modified By:
 */
public class LeetCode316 {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> result=new ArrayList<>();
        int len=primes.length;
        result.add(1);
        int cur=2;
        int[] indexs=new int[len];
        while (result.size()<n){
            int min=Integer.MAX_VALUE;
            for (int i=0;i<indexs.length;i++) {
                while (result.get(indexs[i]) * primes[i] < cur) {
                    indexs[i]++;
                }
                min = Math.min(min, result.get(indexs[i]) * primes[i]);
            }
            cur=min+1;
            result.add(min);
        }
        return result.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(2,new int[]{2,3,5}));
    }
}
