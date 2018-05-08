package leetcode;

/**
 * @Author ROKG
 * @Description 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * @Date: Created in 下午1:26 2018/5/8
 * @Modified By:
 */
public class LeetCode812 {

    public double largestTriangleArea(int[][] points) {
        double max=0;
        for (int i=0;i<points.length-2;i++){
            for (int j=i+1;j<points.length-1;j++){
                for (int k=j+1;k<points.length;k++){
                    max=Math.max(max,Math.abs(points[i][0]*points[j][1]+points[j][0]*points[k][1]+points[k][0]*points[i][1]-
                    points[j][0]*points[i][1]-points[k][0]*points[j][1]-points[i][0]*points[k][1])/2.0);
                }
            }
        }
        return max;
    }
}
