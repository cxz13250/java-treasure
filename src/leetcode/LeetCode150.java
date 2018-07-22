package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * @Date: Created in 上午10:49 2018/7/22
 * @Modified By:
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String s:tokens){
            if (isOperator(s)){
                Integer s1=stack.pop();
                Integer s2=stack.pop();
                stack.push((calculate(s1, s2, s)));
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return Integer.valueOf(stack.peek());
    }

    private boolean isOperator(String s){
        return "*".equals(s) || "/".equals(s) || "+".equals(s) || "-".equals(s);
    }

    private int calculate(Integer num1, Integer num2, String op){
        if ("+".equals(op)){
            return num1+num2;
        }else if ("-".equals(op)){
            return num1-num2;
        }else if ("*".equals(op)){
            return num1*num2;
        }else if ("/".equals(op)){
            return num1/num2;
        }else {
            return -1;
        }
    }


}
