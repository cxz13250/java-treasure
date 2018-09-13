package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 题中给出一个 n 行 n 列的二维矩阵 (n_rows,n_cols)，且所有值被初始化为 0。
 * 要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；
 * 同样编写一个 reset 函数，将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。
 * @Date: Created in 上午9:33 2018/9/9
 * @Modified By: *
 */
public class LeetCode519 {

    int rows,cols,total;

    Random random;

    Set<Integer> set=new HashSet<>();

    public LeetCode519(int n_rows, int n_cols) {
        set=new HashSet<>();
        rows=n_rows;
        cols=n_cols;
        total=rows*cols;
        random=new Random();
    }

    public int[] flip() {
        int index=random.nextInt(total);
        while (!set.add(index)){
            index=random.nextInt(total);
        }
        return new int[]{index/cols,index%cols};
    }

    public void reset() {
         set.clear();
    }

    public static void main(String[] args) {

    }
}
