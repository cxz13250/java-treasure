package leetcode;

import java.util.Random;

/**
 * @Author ROKG
 * @Description 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的 Math.random() 方法。
 * @Date: Created in 上午12:22 2018/7/25
 * @Modified By: *
 */
public class LeetCode470 {

    public int rand10() {
        int num=rand40();
        return num%10+1;
    }

    public int rand40(){
        int num=rand49();
        while (num>=40){
            num=rand49();
        }
        return num;
    }

    public int rand49(){
        return 7 * (rand7() - 1) + rand7() - 1;
    }

    public int rand7(){
        return new Random().nextInt(7);
    }
}
