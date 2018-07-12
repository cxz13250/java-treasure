package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * @Date: Created in 下午5:29 2018/7/3
 * @Modified By:
 */
public class LeetCode227 {

    public int calculate(String s) {
        Stack<Integer> nums=new Stack<>();
        Stack<Character> operators=new Stack<>();
        int i=0;
        while (i<s.length()) {
            char c = s.charAt(i);
            while (c == ' '&&i<s.length()) {
                i++;
                if (i>=s.length()){
                    break;
                }
                c=s.charAt(i);
            }
            String numStr="";
            while (i<s.length()&&c>='0'&&c<='9'){
                numStr+=c;
                i++;
                if (i>=s.length()){
                    break;
                }
                c=s.charAt(i);
            }
            if (numStr.length()>0){
                int temp=Integer.valueOf(numStr);
                nums.push(temp);
            }
            if (c==' '){
                continue;
            }
            if (c=='-'||c=='+'||c=='*'||c=='/'){
                if (operators.isEmpty()){
                    operators.push(c);
                }else {
                    if (c=='-'||c=='+'){
                        while (!operators.isEmpty()){
                            int n=nums.pop();
                            int n1=nums.pop();
                            char op=operators.pop();
                            nums.push(compute(n,n1,op));
                        }
                        operators.push(c);
                    }else if (c=='*'||c=='/'){
                        while (!operators.isEmpty()&&operators.peek()!='-'&&operators.peek()!='+'){
                            int n=nums.pop();
                            int n1=nums.pop();
                            char op=operators.pop();
                            nums.push(compute(n,n1,op));
                        }
                        operators.push(c);
                    }
                }
                i++;
            }
        }
        while (!operators.isEmpty()){
            int n=nums.pop();
            int n1=nums.pop();
            char op=operators.pop();
            nums.push(compute(n,n1,op));
        }
        return nums.pop();
    }

    public int compute(int num1 , int num2 , char op){
        if (op == '+'){
            return num1 + num2;
        } else if (op == '-'){
            return num1 - num2;
        } else if (op == '*'){
            return num1 * num2;
        } else if (op == '/'){
            return num1 / num2;
        }
        return -1;
    }
}
