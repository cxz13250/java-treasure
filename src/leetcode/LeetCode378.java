package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author ROKG
 * @Description 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * @Date: Created in 下午4:34 2018/6/21
 * @Modified By:
 */
public class LeetCode378 {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                queue.offer(matrix[i][j]);
            }
        }
        int count=0;
        int result=-1;
        while (count<k){
            result=queue.poll();
            count++;
        }
        return result;
    }

    //优化复杂度
    class Number{
        int row;
        int col;
        int val;
        Number(int row, int col, int val){
            this.row=row;
            this.col=col;
            this.val=val;
        }
    }

    public int kthSmallest2(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        PriorityQueue<Number> queue=new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.val-o2.val;
            }
        });
        for (int i=0;i<matrix.length;i++){
            queue.offer(new Number(i,0,matrix[i][0]));
        }
        int count=0;
        int result=-1;
        while (count<k){
            Number n=queue.poll();
            result=n.val;
            if (n.col<matrix[0].length){
                queue.offer(new Number(n.row,n.col+1,matrix[n.row][n.col+1]));
            }
            count++;
        }
        return result;
    }
}
