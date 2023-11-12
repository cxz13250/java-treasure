package leetcode2;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午3:35 2023/11/4
 * @Modified By:
 */
public class Leet150_ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(calculate(b, a, s));
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    private boolean isOperator(String s) {
        return Arrays.asList(new String[]{"+","-","*","/"}).contains(s);
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

    public static void main(String[] args) {
        System.out.println(new Leet150_ReversePolishNotation().evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
