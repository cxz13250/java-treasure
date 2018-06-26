package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 * @Date: Created in 下午2:22 2018/6/19
 * @Modified By: *
 */
public class LeetCode593 {


    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set=new HashSet<>();
        int d1=dis(p1,p2);
        int d2=dis(p1,p3);
        int d3=dis(p1,p4);
        int d4=dis(p2,p3);
        int d5=dis(p2,p4);
        int d6=dis(p3,p4);
        if (d1 == 0 || d2 == 0 || d3 == 0 || d4 == 0 || d5 == 0 || d6 == 0)
            return false;
        set.add(d1);
        set.add(d2);
        set.add(d3);
        set.add(d4);
        set.add(d5);
        set.add(d6);
        return set.size()==2;
    }

    public int dis(int[] p1, int[] p2){
        return (int)(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2));
    }
}
