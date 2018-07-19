package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * @Date: Created in 下午10:49 2018/7/17
 * @Modified By: *
 */
public class LeetCode402 {

    //贪心算法
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()){
            return "0";
        }
        Stack<Integer> stack=new Stack<>();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<num.length();i++){
            int n=num.charAt(i)-'0';
            while (!stack.isEmpty()&&k>0&&stack.peek()>n){
                stack.pop();
                k--;
            }
            stack.push(n);
        }
        while (k>0){
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        char[] cc=sb.reverse().toString().toCharArray();
        int index=0;
        while (index<cc.length&&cc[index]=='0'){
            index++;
        }
        if (index==cc.length){
            return "0";
        }else {
            return new String(cc,index,cc.length-index);
        }
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1173",2));
    }
}
