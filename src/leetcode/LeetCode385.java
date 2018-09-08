package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * @Date: Created in 2018/9/4
 * @Modified By:
 */
public class LeetCode385 {

    public class NestedInteger {
            // Constructor initializes an empty nested list.
            NestedInteger(){}
            // Constructor initializes a single integer.
            NestedInteger(int value){}
            // @return true if this NestedInteger holds a single integer, rather than a nested list.
            public boolean isInteger(){
                return true;
            }
            // @return the single integer that this NestedInteger holds, if it holds a single integer
            // Return null if this NestedInteger holds a nested list
            public Integer getInteger(){
                return 1;
            }
            // Set this NestedInteger to hold a single integer.
            public void setInteger(int value){}
            // Set this NestedInteger to hold a nested list and adds a nested integer to it.
            public void add(NestedInteger ni){}
            // @return the nested list that this NestedInteger holds, if it holds a nested list
           // Return null if this NestedInteger holds a single integer
           public List<NestedInteger> getList(){return new ArrayList<>();}
    }

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stackNested=new Stack<>();
        Stack<Character> stackChar=new Stack<>();
        char[] cc=s.toCharArray();
        for (int i=0;i<cc.length;i++){
            if (cc[i]=='['){
                stackChar.push(cc[i]);
            }else if (cc[i]!='['&&cc[i]!=','&&cc[i]!=']'){
                int start=i;
                while (i<cc.length&&cc[i]!='['&&cc[i]!=','&&cc[i]!=']'){
                    i++;
                }
                String str=s.substring(start, i);
                stackNested.push(new NestedInteger(Integer.valueOf(str)));
                stackChar.push('1');
            }else if (cc[i]==']'){
                NestedInteger n=new NestedInteger();
                List<NestedInteger> list=n.getList();
                while (stackChar.pop()=='1'){
                    list.add(0,stackNested.pop());
                }
                stackNested.push(n);
                stackChar.push('1');
            }
        }
        return stackNested.pop();
    }
}
