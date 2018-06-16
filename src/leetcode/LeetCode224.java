package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * @Date: Created in 下午3:46 2018/6/2
 * @Modified By:
 */
public class LeetCode224 {

    Stack<Character> operators=new Stack<>();
    Stack<Integer> nums=new Stack<>();

    public int calculate(String s) {
        int i=0;
        while (i<s.length()){
            char c=s.charAt(i);
            if (c==' '){
                i++;
                continue;
            }
            int num=0;
            boolean isNum=false;
            while (c!='+'&&c!='-'&&c!='('&&c!=')'&&c!=' '&&i<s.length()){
                isNum=true;
                num=num*10+(c-'0');
                i++;
                if (i<s.length()){
                    c=s.charAt(i);
                }
            }
            if (isNum){
                nums.push(num);
            }
            if (c=='('){
                operators.push(c);
            }else if (c==')'){
                while (!operators.isEmpty()&&!(operators.peek()=='(')){
                    char ch=operators.pop();
                    compute(ch);
                }
                operators.pop();
            }else if (c=='+'||c=='-'){
                while (!operators.isEmpty()&&(operators.peek()=='+'||operators.peek()=='-')){
                    char ch=operators.pop();
                    compute(ch);
                }
                operators.push(c);
            }
            i++;
        }
        while (!operators.isEmpty()){
            char c=operators.pop();
            compute(c);
        }
        return nums.pop();
    }

    public void compute(char c){
        int num1=nums.pop();
        int num2=nums.pop();
        if (c=='+'){
            nums.push(num1+num2);
        }else if (c=='-'){
            nums.push(num2-num1);
        }
    }

    public static void main(String[] args) {
        LeetCode224 l=new LeetCode224();
        System.out.println(l.calculate("2147483647"));
    }
}
