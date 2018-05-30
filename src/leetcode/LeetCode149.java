package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * @Date: Created in 下午1:43 2018/5/23
 * @Modified By: *
 */
public class LeetCode149 {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public static int maxPoints(Point[] points) {
        if (points.length<=1){
            return points.length;
        }
        Map<Double,Integer> same=new HashMap<>();
        int max=0;
        for (int i=0;i<points.length;i++){
            same.clear();
            Point p=points[i];
            int duplicate=0;
            for (int j=0;j<points.length;j++){
                if (i==j){
                    continue;
                }
                Point q=points[j];
                if (p.x==q.x&&p.y==q.y){
                    duplicate++;
                    continue;
                }else if (p.x==q.x){
                    same.put(Double.MAX_VALUE,same.getOrDefault(Double.MAX_VALUE,0)+1);
                }else {
                    double k=(p.y-q.y)*1.0/(p.x-q.x)*1.0;
                    same.put(k,same.getOrDefault(k,0)+1);
                }
            }
            for (Double key:same.keySet()){
                max=Math.max(max,same.get(key)+duplicate+1);
            }
            if (same.keySet().size()==0){
                max=Math.max(max,duplicate+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
    }
}

