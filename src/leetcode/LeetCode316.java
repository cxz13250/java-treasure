package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @Date: Created in 2018/8/17
 * @Modified By: *
 */
public class LeetCode316 {

    // 栈的特性
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map =new HashMap<>();
        char[] cc=s.toCharArray();
        for (char c:cc){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        boolean[] visit=new boolean[128];
        for (char c:cc){
            map.put(c, map.get(c)-1);
            if (visit[c]){
                continue;
            }
            while (stack.size()>0&&map.get(stack.peek())>0&&c<stack.peek()){
                visit[stack.peek()]=false;
                stack.pop();
            }
            stack.push(c);
            visit[c]=true;
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
