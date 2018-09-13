package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给出一个非抢占单线程CPU的 n 个函数运行日志，找到函数的独占时间。
 * 每个函数都有一个唯一的 Id，从 0 到 n-1，函数可能会递归调用或者被其他函数调用。
 * 日志是具有以下格式的字符串：function_id：start_or_end：timestamp。例如："0:start:0" 表示函数 0 从 0 时刻开始运行。"0:end:0" 表示函数 0 在 0 时刻结束。
 * 函数的独占时间定义是在该方法中花费的时间，调用其他函数花费的时间不算该函数的独占时间。你需要根据函数的 Id 有序地返回每个函数的独占时间。
 * @Date: Created in 2018/9/13
* @Modified By: *
 */
public class LeetCode636 {

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res=new int[n];
        String[] last=logs.get(0).split(":");
        Stack<Integer> queue=new Stack<>();
        queue.push(Integer.valueOf(last[0]));
        for (int i=1;i<logs.size();i++){
            String[] cur=logs.get(i).split(":");
            if (cur[1].equals("start")){
                if (last[1].equals("start")){
                    res[Integer.valueOf(last[0])]+=Integer.valueOf(cur[2])-Integer.valueOf(last[2]);
                }else {
                    if (!queue.isEmpty()){
                        int pre=queue.peek();
                        res[pre]+=Integer.valueOf(cur[2])-Integer.valueOf(last[2])-1;
                    }
                }
                queue.push(new Integer(cur[0]));
            }else {
                queue.pop();
                if (last[1].equals("start")){
                    res[Integer.valueOf(last[0])]+=Integer.valueOf(cur[2])-Integer.valueOf(last[2])+1;
                }else {
                    res[Integer.valueOf(cur[0])]+=Integer.valueOf(cur[2])-Integer.valueOf(last[2]);
                }
            }
            last=cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(exclusiveTime(2, new ArrayList<String>(){
            {
                add("0:start:0");
                add("0:start:2");
                add("0:end:5");
                add("1:start:7");
                add("1:end:7");
                add("0:end:8");
            }
        }));
        System.out.println(exclusiveTime(8, new ArrayList<String>(){
            {
                add("0:start:0");
                add("1:start:5");
                add("2:start:6");
                add("3:start:9");
                add("4:start:11");
                add("5:start:12");
                add("6:start:14");
                add("7:start:15");
                add("1:start:24");
                add("1:end:29");
                add("7:end:34");
                add("6:end:37");
                add("5:end:39");
                add("4:end:40");
                add("3:end:45");
                add("0:start:49");
                add("0:end:54");
                add("5:start:55");
                add("5:end:59");
                add("4:start:63");
                add("4:end:66");
                add("2:start:69");
                add("2:end:70");
                add("2:start:74");
                add("6:start:78");
                add("0:start:79");
                add("0:end:80");
                add("6:end:85");
                add("1:start:89");
                add("1:end:93");
                add("2:end:96");
                add("2:end:100");
                add("1:end:102");
                add("2:start:105");
                add("2:end:109");
                add("0:end:114");
            }
        }));
    }
}
