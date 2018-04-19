package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @Date: Created in 下午1:25 2018/4/18
 * @Modified By:
 */
public class LeetCode20 {

    public static boolean isValid(String s) {
        Stack<Character> characters=new Stack<>();
        char[] cc=s.toCharArray();
        for(char c:cc){
            if(c=='{'||c=='['||c=='('){
                characters.push(c);
            }else {
                if(characters.empty()){
                    return false;
                }
                char temp=characters.peek();
                switch (c){
                    case '}': if(temp!='{'){
                        return false;
                    } break;
                    case ']': if(temp!='['){
                        return false;
                    } break;
                    case ')': if (temp!='('){
                        return false;
                    } break;
                }
                characters.pop();
            }
        }
        if(!characters.empty()){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
//        String str="()[]{}";
//        System.out.println(isValid(str));
        String str1="{[]}";
        System.out.println(isValid(str1));
    }
}
