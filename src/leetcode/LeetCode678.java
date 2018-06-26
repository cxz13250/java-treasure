package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * @Date: Created in 下午3:24 2018/6/25
 * @Modified By:
 */
public class LeetCode678 {

    public static boolean checkValidString(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='('||c=='*'){
                stack.push(c);
            }else {
                if (!stack.isEmpty()){
                    int count=0;
                    while (!stack.isEmpty()&&stack.peek()=='*'){
                        stack.pop();
                        count++;
                    }
                    if (stack.isEmpty()){
                        count--;
                    }else {
                        stack.pop();
                    }
                    while (count>0){
                        stack.push('*');
                        count--;
                    }
                }else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        int flag=0;
        while (!stack.isEmpty()){
            if (stack.peek()=='*'){
                flag++;
            }else if (stack.peek()=='('){
                if (flag==0){
                    return false;
                }else {
                    flag--;
                }
            }
            stack.pop();
        }
        return true;
    }

    public static boolean checkValidString2(String s) {
        Stack<Integer> star = new Stack<>();
        Stack<Integer> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c=='*'){
                star.push(i);
            } else {
                if (!left.isEmpty()){
                    left.pop();
                }else if (!star.isEmpty()){
                    star.pop();
                }else {
                    return false;
                }
            }
        }
        while (!left.isEmpty()&&!star.isEmpty()){
            if (left.pop()>star.pop()){
                return false;
            }else {
                left.pop();
                star.pop();
            }
        }
        return left.isEmpty();
    }
}
