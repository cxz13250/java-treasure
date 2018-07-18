package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ROKG
 * @Description 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * @Date: Created in 下午11:23 2018/7/16
 * @Modified By:
 */
public class LeetCode386 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i=1;i<=9;i++){
            check(i,n);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    public void check(int cur,int n){
        if (cur<=n){
            list.add(cur);
        }else {
            return;
        }
        for (int i=0;i<=9;i++){
            check(cur*10+i,n);
        }
    }
}
