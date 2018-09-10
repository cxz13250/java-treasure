package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
 * @Date: Created in 2018/9/10
 * @Modified By: *
 */
public class LeetCode335 {

    // 判断x[i]是否造成路径相交，秩序判断x[i]与x[i-2]的大小
    // 存在四种情况：第一种，路径一直螺旋减小，不会相交；第二种，路径一直螺旋增大，不会相交；
    // 第三种，路径先螺旋减小，再螺旋增大，必相交；第四种，路径先螺旋增大，再螺旋减小可能会相交。
    // 此题的关键在于第四种，当第四种情况出现时，我们需要根据x[i]+x[i-4]与x[i-2]的关系来更新x[i-1]的值
    public static boolean isSelfCrossing(int[] x) {
          if (x.length<=3){
              return false;
          }
          boolean flag=x[2]>x[0];
          for (int i=3;i<x.length;i++){
              if (!flag&&x[i]>=x[i-2]){   // 先小再大必相交
                  return true;
              }else if (flag&&x[i]<=x[i-2]){   // 先大再小可能相交
                  flag=false;
                  x[i-1]=(x[i]+(i>=4?x[i-4]:0))<x[i-2]?x[i-1]:(x[i-1]-x[i-3]);
              }
          }
          return false;
    }

    static class A{
        int a;
        A(){}
        A(int a){
            this.a=a;
        }
    }

    static class B extends A{
        int b;
        B(int a,int b){
            super(a);
            this.b=b;
        }
    }

    public static void main(String[] args) {

    }
}
