package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @Date: Created in 下午1:27 2018/6/7
 * @Modified By: *
 */
public class LeetCode32 {

    public static int longestValidParentheses(String s) {
        char[] cc=s.toCharArray();
        int next=s.length();
        int max=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<cc.length;i++){
            if (cc[i]==')'){
                if (!stack.isEmpty()&&cc[stack.peek()]=='('){
                    stack.pop();
                    continue;
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int cur=stack.pop();
            int temp=next-cur-1;
            max=Math.max(max,temp);
            next=cur;
        }
        return Math.max(max,next);
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(("));
    }
}
