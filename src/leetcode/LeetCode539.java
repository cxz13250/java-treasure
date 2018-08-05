package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 * @Date: Created in 下午11:52 2018/7/31
 * @Modified By:
 */
public class LeetCode539 {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1=o1.split(":");
                String[] s2=o2.split(":");
                int result1 = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
                int result2 = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
                return result1 - result2;
            }
        });
        int res=Integer.MAX_VALUE;
        for (int i=0;i<timePoints.size();i++){
            int time=0;
            if (i==timePoints.size()-1){
                time=minusTime(timePoints.get(i),timePoints.get(0))+24*60;
            }else {
                time = minusTime(timePoints.get(i), timePoints.get(i + 1));
            }
            res=Math.min(res,time);
        }
        return res;
    }

    public int minusTime(String s1,String s2){
        String[] ss1=s1.split(":");
        String[] ss2=s2.split(":");
        int h1=Integer.valueOf(ss1[0]);
        int h2=Integer.valueOf(ss2[0]);
        int m1=Integer.valueOf(ss1[1]);
        int m2=Integer.valueOf(ss2[1]);
        return h2*60+m2-h1*60-m1;
    }

    public static void main(String[] args) {
        LeetCode539 l=new LeetCode539();
        System.out.println(l.findMinDifference(new ArrayList<String>(){
            {
                add("00:00");
                add("23:59");
            }
        }));
    }
}
