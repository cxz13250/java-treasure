package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * @Date: Created in 下午7:30 2018/6/9
 * @Modified By:
 */
public class LeetCode216 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        check(1,n,0,new ArrayList<>(),k);
        return result;
    }

    public void check(int from,int sum,int step,List<Integer> list,int length){
        if (sum<0){
            return;
        }
        if (step==length) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i=from;i<10&&i<=sum;i++) {
            list.add(i);
            check(i+1,sum-i,step+1,list,length);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        LeetCode216 l=new LeetCode216();
        System.out.println(l.combinationSum3(3,7));
    }
}
