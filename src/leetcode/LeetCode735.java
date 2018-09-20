package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * @Date: Created in 2018/9/19
 * @Modified By:
 */
public class LeetCode735 {

    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> list=new ArrayList<>();
        Stack<Integer> right=new Stack<>();
        Stack<Integer> left=new Stack<>();
        for (int i=0;i<asteroids.length;i++){
            if (asteroids[i]<0) {
                int status=1; // 1活着,0死了
                while (!right.isEmpty()) {
                    int index = right.pop();
                    if (Math.abs(asteroids[index]) > Math.abs(asteroids[i])) {
                        status=0;
                        right.push(index);
                        break;
                    }else if (Math.abs(asteroids[index]) == Math.abs(asteroids[i])){
                        status=0;
                        break;
                    }
                }
                if (status==1) {
                    left.push(i);
                }
            }else {
                right.push(i);
            }
        }
        int[] res=new int[right.size()+left.size()];
        int i=res.length-1;
        while (!right.isEmpty()){
            res[i--]=asteroids[right.pop()];
        }
        while (!left.isEmpty()){
            res[i--]=asteroids[left.pop()];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(asteroidCollision(new int[]{5,10,-5}));
    }
}
