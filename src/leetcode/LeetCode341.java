package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 2018/9/13
 * @Modified By:
 */
public class LeetCode341 implements Iterator<Integer> {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();
         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
    }

    List<Integer> integers;
    Iterator<Integer> iterator;

    public LeetCode341(List<NestedInteger> nestedList) {
        Stack<NestedInteger> stack = new Stack<>();
        integers=new ArrayList<>();
        for (int i=nestedList.size()-1;i>=0;i--){
            stack.push(nestedList.get(i));
        }
        while (!stack.isEmpty()){
            NestedInteger integer=stack.pop();
            if (integer.getInteger()!=null){
                integers.add(integer.getInteger());
            }
            List<NestedInteger> tmp=integer.getList();
            for (int i=tmp.size()-1;i>=0;i--){
                stack.push(tmp.get(i));
            }
        }
        iterator = integers.iterator();
    }
    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public static void main(String[] args) {

    }
}
