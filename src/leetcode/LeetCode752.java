package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author ROKG
 * @Description 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * @Date: Created in 2018/9/21
 * @Modified By: *
 */
public class LeetCode752 {

    // BFS
    public int openLock(String[] deadends, String target) {
        for (String s:deadends){
            if (s.equals("0000")){
                return -1;
            }
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer("0000");
        Set<String> used=new HashSet<>();
        used.add("0000");
        int res=0;
        while (!queue.isEmpty()){
            int n=queue.size();
            while (n-->0){
                String s=queue.poll();
                if (s.equals(target)){
                    return res;
                }
                String[] ss=change(s);
                for (String str:ss){
                    if (!used.contains(str)){
                        queue.offer(new String(str));
                        used.add(new String(str));
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public String[] change(String s){
        String[] res=new String[8];
        for (int i=0;i<4;i++){
            res[2*i]=s.substring(0,i)+(s.charAt(i)-'0'+1)%10+s.substring(i+1,4);
            res[2*i+1]=s.substring(0,i)+(s.charAt(i)-'0'+9)%10+s.substring(i+1,4);
        }
        return res;
    }
}
