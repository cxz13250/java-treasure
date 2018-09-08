package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 在一个二维的花园中，有一些用 (x,y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。
 * 只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 * @Date: Created in 上午11:53 2018/9/2
 * @Modified By: *
 */
public class LeetCode578 {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public List<Point> outerTrees(Point[] points) {
        List<Point> res=new ArrayList<>();
        Point first=points[0];
        int firstIdx=0,n=points.length;
        for (int i=1;i<n;i++){
            if (points[i].x<first.x){
                first=points[i];
                firstIdx=i;
            }
        }
        res.add(first);
        Point cur=first;
        int curIdx=firstIdx;
        while (true){
            Point next=points[0];
            int nextIdx=0;
            for (int i=1;i<n;i++){
                if (i!=curIdx){
                    int cross=cross(cur,points[i],next);
                    if (nextIdx==curIdx||cross>0||(cross==0&&dist(points[i],cur)>dist(next,cur))){
                        next=points[i];
                        nextIdx=i;
                    }
                }
            }
            for (int i=0;i<n;i++){
                if (i!=curIdx){
                    int cross=cross(cur,points[i],next);
                    if (cross==0&&check(res,points[i])){
                        res.add(points[i]);
                    }
                }
            }
            cur = next;
            curIdx = nextIdx;
            if (curIdx==firstIdx){
                break;
            }
        }
        return res;
    }

    public int cross(Point a,Point b,Point c){
        int bax=a.x-b.x;
        int bay=a.y-b.y;
        int bcx=c.x-b.x;
        int bcy=c.y-b.y;
        return bax*bcy-bay*bcx;
    }

    public int dist(Point a,Point b){
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
    }

    public boolean check(List<Point> points,Point a){
        for (Point p:points){
            if (p.x==a.x&&p.y==a.y){
                return false;
            }
        }
        return true;
    }
}
