package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * @Date: Created in 下午3:22 2018/6/10
 * @Modified By: *
 */
public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {
        Stack<String> stack=new Stack<>();
        String[] strings=preorder.split(",");
        for (String s:strings){
            if (!s.equals("#")){
                stack.push(s);
            }else {
                if (stack.isEmpty()||!stack.peek().equals("#")){
                    stack.push(s);
                }else {
                    while (!stack.isEmpty()&&stack.peek().equals("#")){
                        stack.pop();
                        if (stack.isEmpty()){
                            return false;
                        }
                        String temp=stack.pop();
                        if (temp.equals("#")){
                            return false;
                        }
                    }
                    stack.push("#");
                }
            }
        }

        if (stack.isEmpty()){
            return false;
        }
        if (!stack.pop().equals("#")||!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean isValidSerialization1(String preorder) {
        Stack<String> strings=new Stack<>();
        int index=1;
        String[] ss=preorder.split(",");
        strings.push(ss[0]);
        while (!strings.isEmpty()){
            String temp=strings.pop();
            if(!temp.equals("#")){
                if (index<ss.length){
                    strings.push(ss[index++]);
                }else {
                    return false;
                }
                if (index<ss.length){
                    strings.push(ss[index++]);
                }else {
                    return false;
                }
            }
        }
        return index==preorder.length();
    }

    //计算入度和出度的差
    public boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
