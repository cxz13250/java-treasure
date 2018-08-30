package leetcode;

import java.util.TreeSet;

/**
 * @Author ROKG
 * @Description 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * @Date: Created in 2018/8/30
 * @Modified By: *
 */
public class LeetCode363 {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length;
        if (m==0){
            return 0;
        }
        int n=matrix[0].length;
        if (n==0){
            return 0;
        }
        int M=Math.max(m, n);
        int N=Math.min(m, n);
        int max=Integer.MIN_VALUE;
        for (int x=0;x<N;x++){
            int sum[] =new int[M];
            for (int y=x;y<N;y++){
                TreeSet<Integer> set=new TreeSet<>();
                int num=0;
                for (int z=0;z<M;z++){
                    sum[z]+=m>n?matrix[z][y]:matrix[y][z];
                    num+=sum[z];
                    if (num==k){
                        return k;
                    }else if (num<k){
                        max=Math.max(max, num);
                    }
                    Integer i = set.ceiling(num - k);
                    if (i != null) {
                        max = Math.max(max, num - i);
                    }
                    set.add(num);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][]{{1,0,0},{0,-2,3}}, 2));
    }
}
