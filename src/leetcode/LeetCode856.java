package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * @Date: Created in 2018/7/23
 * @Modified By:
 */
public class LeetCode856 {

    public int scoreOfParentheses(String S) {
        if (S==null || S.trim().length()==0){
            return 0;
        }
        Stack<String> stack = new Stack<>();
        char[] cc=S.toCharArray();
        for (char c:cc){
            if (c=='('){
                stack.push(String.valueOf(c));
            }else if (c==')'){
                int temp=0;
                while (!"(".equals(stack.peek())){
                    String s=stack.pop();
                    temp+=Integer.valueOf(s);
                }
                stack.pop();
                if (temp==0){
                    temp++;
                }else {
                    temp*=2;
                }
                stack.push(String.valueOf(temp));
            }
        }
        int result=0;
        while (!stack.isEmpty()){
            result+=Integer.valueOf(stack.pop());
        }
        return result;
    }
}
