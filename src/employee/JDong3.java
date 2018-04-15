package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author ROKG
 * @Description 判断字符串如："((()))("能否一次交换就闭合
 * @Date: Created in 下午8:15 2018/4/9
 * @Modified By:
 */
public class JDong3 {

    public void check(char[] arr){
        int l=0;
        int r=0;
        if(arr.length<2 || (arr[0]==')'&&arr[1]==')')){
            System.out.println("No");
            return;
        }
        for(char c:arr){
            if(c=='('){
                l+=1;
            }else {
                r+=1;
            }
        }
        if(l!=r){
            System.out.println("No");
            return;
        }
        Stack<Character> stack=new Stack<Character>();
        for(char c:arr){
            if(c=='('){
                stack.push(c);
            }else {
                if(stack.empty()||stack.peek()==')'){
                    stack.push(c);
                }else {
                    stack.pop();
                }
            }
        }
        if(stack.size()<=4){
            System.out.println("Yes");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        JDong3 t=new JDong3();
        List<String> strings=new ArrayList<>();
        for(int i=0;i<n;i++){
            strings.add(sc.next());
        }
        for (String str:strings){
            char[] arr=str.toCharArray();
            t.check(arr);
        }
    }
}
