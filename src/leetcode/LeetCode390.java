package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 * @Date: Created in 下午11:02 2018/7/21
 * @Modified By: *
 */
public class LeetCode390 {

    public int lastRemaining(int n) {
        int flag=0; //0从左边开始，1从右边开始
        List<Integer> pre=new ArrayList<>();
        for (int i=1;i<=n;i++) {
            pre.add(i);
        }
        while (pre.size()>1){
            List<Integer> cur=new ArrayList<>();
            if (flag==0){
                for (int i=1;i<pre.size();i+=2){
                    cur.add(pre.get(i));
                }
                flag=1;
            }else if (flag==1){
                for (int i=pre.size()-2;i>0;i-=2){
                    cur.add(0,pre.get(i));
                }
                flag=0;
            }
            pre=cur;
        }
        return pre.get(0);
    }

    //只看当前元素序列之首的位置，只有两种情况head需要移动，第一种从左开始删，第二种从右开始删且元素数量为奇数
    public int lastRemaining2(int n) {
        int head=1;
        int remain=n;
        int step=1;
        boolean left=true;
        while (remain>1){
            if (left || remain%2==1){
                head+=step;
            }
            remain/=2;
            step*=2;
            left=!left;
        }
        return head;
    }


}
