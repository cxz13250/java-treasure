package leetcode;

import java.util.Random;

/**
 * @Author ROKG
 * @Description 给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
 * 说明:
 * 输入值和输出值都将是浮点数。
 * 圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
 * 圆周上的点也认为是在圆中。
 * randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
 * @Date: Created in 上午11:19 2018/8/20
 * @Modified By:
 */
public class LeetCode478 {

    double x,y,radius;

    Random random;

    public LeetCode478(double radius, double x_center, double y_center) {
        this.x=x_center;
        this.y=y_center;
        this.radius=radius;
        random=new Random();
    }

    public double[] randPoint() {
        double posX,posY;
        do{
            posX=random.nextDouble()*(double)2*radius-(radius-x);
            posY=random.nextDouble()*(double)2*radius-(radius-y);
        }while (((x-posX)*(x-posX)+(y-posY)*(y-posY))>radius*radius);
        double[] res=new double[2];
        res[0]=posX;
        res[1]=posY;
        return res;
    }

    public static void main(String[] args) {
        LeetCode478 l =new LeetCode478(0.01,-73839.1,-3289891.3);
        double[] d=l.randPoint();
        System.out.println(d[0]+","+d[1]);
    }
}
