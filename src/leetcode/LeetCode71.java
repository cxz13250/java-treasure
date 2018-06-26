package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * @Date: Created in 下午10:57 2018/6/23
 * @Modified By:
 */
public class LeetCode71 {

    Stack<String> stack=new Stack<>();

    public String simplifyPath(String path) {
        if (path.length()==0){
            return "/";
        }
        check(path,0);
        StringBuilder sb=new StringBuilder();
        if (stack.isEmpty()){
            return "/";
        }
        Stack<String> result=new Stack<>();
        while (!stack.isEmpty()){
            result.push(stack.pop());
        }
        while (!result.isEmpty()){
            sb.append(result.pop());
        }
        return sb.toString();
    }

    public void check(String s,int start){
         if (start>=s.length()){
             return;
         }
         int i=start+1;
         boolean flag=false;
         while (i<s.length()&&s.charAt(i)=='/'){
             start=i;
             i++;
         }
         while (i<s.length()&&s.charAt(i)!='/'){
             flag=true;
             i++;
         }
         if (!flag&&i>=s.length()){
             return;
         }
         String temp=s.substring(start,i);
         if ("/..".equals(temp)){
             if (!stack.isEmpty()){
                 stack.pop();
             }
         }else if (!"/.".equals(temp)){
             stack.push(temp);
         }
         check(s,i);
    }

    public static void main(String[] args) {
        LeetCode71 l=new LeetCode71();
        System.out.println(l.simplifyPath("/..."));
    }
}
