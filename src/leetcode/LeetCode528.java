package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ROKG
 * @Description 给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
 * @Date: Created in 下午2:55 2018/9/9
 * @Modified By: *
 */
public class LeetCode528 {

    int[] w;

    int total;

    public LeetCode528(int[] w) {
        this.w=w;
        total= Arrays.stream(w).sum();
        for (int i=1;i<w.length;i++){
            w[i]+=w[i-1];
        }
    }

    // w为概率累计数组，二分查找第一个大于目标概率的元素
    public int pickIndex() {
        int index=new Random().nextInt(total);
        int start=0,end=w.length-1;
        while (start<end){
            int mid=(start+end)/2;
            if (index>=w[mid]){
                start=mid;
            }else {
                end=mid;
            }
        }
        if (index<w[start]){
            return start;
        }
        return end;
    }
}
