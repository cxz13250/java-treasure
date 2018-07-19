package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @Date: Created in 下午2:56 2018/6/29
 * @Modified By:
 */
public class LeetCode77 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<>();
        check(n,k,1,list);
        return result;
    }

    public void check(int n,int k,int i,List<Integer> list){
        if (list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        if (i>n || list.size()>k){
            return;
        }
        list.add(i);
        check(n,k,i+1,list);
        list.remove(list.size()-1);
        check(n,k,i+1,list);
    }

    public static void main(String[] args) {
        LeetCode77 l=new LeetCode77();
        System.out.println(l.combine(4,2));
    }
}
