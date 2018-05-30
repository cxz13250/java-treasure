package leetcode;

import java.util.Arrays;
import java.util.Vector;

/**
 * @Author ROKG
 * @Description 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h指数的定义: “一位有 h 指数的学者，代表他（她）的 N 篇论文中至多有 h 篇论文，分别被引用了至少 h 次，其余的 N - h 篇论文每篇被引用次数不多于 h 次。"
 * @Date: Created in 下午11:00 2018/5/25
 * @Modified By:
 */
public class LeetCode274 {


    public static int hIndex(int[] citations) {
        if (citations.length<=0){
            return 0;
        }
        Arrays.sort(citations);
        int result=0;
        for (int i=citations.length-1;i>=0;i--){
            if (result>=citations[i]){
                return Math.max(result,citations[i]);
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={0,3,2,0};
        System.out.println(hIndex(nums));
    }
}
