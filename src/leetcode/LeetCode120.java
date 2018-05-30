package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * @Date: Created in 上午11:05 2018/5/23
 * @Modified By: *
 */
public class LeetCode120 {


    public int minimumTotal(List<List<Integer>> triangle) {
        int result=Integer.MAX_VALUE;
        if (triangle.size()==0){
            return 0;
        }
        int[][] paths=new int[triangle.size()][triangle.size()];
        paths[0][0]=triangle.get(0).get(0);
        for (int i=1;i<triangle.size();i++){
            paths[i][0]=paths[i-1][0]+triangle.get(i).get(0);
            paths[i][i]=paths[i-1][i-1]+triangle.get(i).get(i);
        }
        for (int i=2;i<triangle.size();i++){
            for (int j=1;j<i;j++){
                paths[i][j]=triangle.get(i).get(j)+Math.min(paths[i-1][j-1],paths[i-1][j]);
            }
        }
        for (int i=0;i<triangle.size();i++){
            result=Math.min(result,paths[triangle.size()-1][i]);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>(){
            {
                add(6);
                add(5);
                add(7);
            }
        };
        Collections.sort(list);
        System.out.println(list);
    }
}
