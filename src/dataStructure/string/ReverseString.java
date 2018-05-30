package dataStructure.string;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 字符串反转
 * @Date: Created in 下午2:35 2018/5/24
 * @Modified By:
 */
public class ReverseString {

    //逆序遍历 数组/StringBuilder
    public String reverse(String str){
        if (str==null||str.length()==0){
            return str;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //栈
    public String reverse1(String str){
        if (str==null||str.length()==0){
            return str;
        }
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for (char c:str.toCharArray()){
            stack.push(c);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    //位运算
    public static String reverse2(String str){
        if (str==null||str.length()==0){
            return str;
        }
        char[] cc=str.toCharArray();
        int length = str.length()-1;
        for (int i=0;i<length;i++,length--){
            cc[i]^=cc[length];
            cc[length]^=cc[i];
            cc[i]^=cc[length];
        }
        return new String(cc);
    }

    //递归
    public static String reverse3(String str){
        if (str==null||str.length()==0){
            return str;
        }
        int length = str.length();
        if (length==1){
            return str;
        }else {
            return reverse3(str.substring(1))+str.charAt(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse2("abc"));
        System.out.println(reverse3("abc"));
    }
}
