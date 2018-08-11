package leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

/**
 * @Author ROKG
 * @Description 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * @Date: Created in 下午11:58 2018/8/7
 * @Modified By:
 */
public class LeetCode836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11=rec1[0];
        int y11=rec1[1];
        int x12=rec1[2];
        int y12=rec1[3];
        int x21=rec2[0];
        int y21=rec2[1];
        int x22=rec2[2];
        int y22=rec2[3];
        if (y12<y21||y22<y11||x11>x22||x12<x21){
            return false;
        }
        return true;
    }
}
