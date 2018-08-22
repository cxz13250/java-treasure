package leetcode;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author ROKG
 * @Description 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
 * @Date: Created in 下午5:20 2018/8/19
 * @Modified By: *
 */
public class LeetCode391 {

    // 完美矩形具备两个特点：（1）四个顶点出现次数为1次，（2）所有小矩形面积之和=四个顶点组成最终矩形面积
    public boolean isRectangleCover(int[][] rectangles) {
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        int bottom=Integer.MAX_VALUE;
        int top=Integer.MIN_VALUE;
        int total=0;
        Set<String> set=new HashSet<>();
        for (int i=0;i<rectangles.length;i++){
            left=Math.min(left,rectangles[i][0]);
            right=Math.max(right,rectangles[i][2]);
            bottom=Math.min(bottom,rectangles[i][1]);
            top=Math.max(top,rectangles[i][3]);
            total+=(rectangles[i][3]-rectangles[i][1])*(rectangles[i][2]-rectangles[i][0]);
            String leftUp=rectangles[i][0]+" "+rectangles[i][3];
            String leftDown=rectangles[i][0]+" "+rectangles[i][1];
            String rightUp=rectangles[i][2]+" "+rectangles[i][3];
            String rightDown=rectangles[i][2]+" "+rectangles[i][1];
            if (!set.contains(leftUp)){
                set.add(leftUp);
            }else {
                set.remove(leftUp);
            }
            if (!set.contains(leftDown)){
                set.add(leftDown);
            }else {
                set.remove(leftDown);
            }
            if (!set.contains(rightUp)){
                set.add(rightUp);
            }else {
                set.remove(rightUp);
            }
            if (!set.contains(rightDown)){
                set.add(rightDown);
            }else {
                set.remove(rightDown);
            }
        }
        if (set.size()==4&&set.contains(left+" "+bottom)&&set.contains(right+" "+top)){
            return total==(top-bottom)*(right-left);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

    }
}
