package leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
 * 当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * 否则，A 可以给 B 发送好友请求。
 * 注意如果 A 向 B 发出了请求，不等于 B 接受了 A 的请求。而且，人们不会给自己发送好友请求。
 * 求总共会发出多少份好友请求?
 * @Date: Created in 2018/8/7
 * @Modified By:
 */
public class LeetCode825 {

    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res=0;
        int flag=-1;
        int count=0;
        for (int i=ages.length-1;i>=0;i--){
            if (ages[i]==flag){//重复出现的数字不用再循环，直接加上第一次出现的count
                res+=count;
                continue;
            }else {
                flag=ages[i];
                count=0;
            }
            for (int j=i-1;j>=0;j--){
                if (ages[j]<=ages[i]*0.5+7){
                    break;
                }
                count++;
            }
            res+=count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{101,56,69,48,30}));
    }
}
