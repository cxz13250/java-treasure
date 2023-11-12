package leetcode2;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午3:43 2023/10/6
 * @Modified By:
 */
public class Leet20_ValidParentheses {

    char LEFT_A = '(';
    char LEFT_B = '[';
    char LEFT_C = '{';
    char RIGHT_A = ')';
    char RIGHT_B = ']';
    char RIGHT_C = '}';

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (LEFT_A == c || LEFT_B == c || LEFT_C == c) {
                stack.add(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (RIGHT_A == c) {
                    char last = stack.pop();
                    if (last != LEFT_A) {
                        return false;
                    }
                } else if (RIGHT_B == c) {
                    char last = stack.pop();
                    if (last != LEFT_B) {
                        return false;
                    }
                } else if (RIGHT_C == c) {
                    char last = stack.pop();
                    if (last != LEFT_C) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
