package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * @Date: Created in 下午3:42 2018/5/8
 * @Modified By:
 */
public class LeetCode447 {

    public static int numberOfBoomerangs(int[][] points) {
        int result=0;
        for (int i=0;i<points.length-2;i++){
            for (int j=i+1;j<points.length-1;j++){
                for (int k=j+1;k<points.length;k++){
                    double edge1=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                    double edge2=(points[i][0]-points[k][0])*(points[i][0]-points[k][0])+(points[i][1]-points[k][1])*(points[i][1]-points[k][1]);
                    double edge3=(points[j][0]-points[k][0])*(points[j][0]-points[k][0])+(points[j][1]-points[k][1])*(points[j][1]-points[k][1]);
                    if (edge1==edge2&&edge2==edge3){
                        result+=3;
                    }else if (edge1==edge2&&edge1!=edge3){
                        result+=2;
                    }else if (edge1==edge3&&edge1!=edge2){
                        result+=2;
                    }else if (edge2==edge3&&edge2!=edge1){
                        result+=2;
                    }
                }
            }
        }
        return result;
    }

    public static int numberOfBoomerangs1(int[][] points){
        int result=0;
        for (int i=0;i<points.length;i++){
            Map<Integer,Integer> map=new HashMap<>();
            for (int j=0;j<points.length;j++){
                int temp=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                if (!map.containsKey(temp)){
                    map.put(temp,0);
                }
                result+=map.get(temp)*2;
                map.put(temp,map.get(temp)+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points={{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }
}
