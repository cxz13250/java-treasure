package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * @Date: Created in 下午10:58 2018/8/7
 * @Modified By:
 */
public class LeetCode301 {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        if (isValid(s)){
            result.add(s);
            return result;
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(s);
        Set<String> visit=new HashSet<>();
        Set<String> queueVisit=new HashSet<>();
        boolean found=false;
        while (!found&&!queue.isEmpty()){
            List<String> cur=new ArrayList<>();
            while (!queue.isEmpty()){
                cur.add(queue.poll());
            }
            for (String str:cur){
                for (int i=0;i<str.length();i++){
                    if (str.charAt(i)!='('&&str.charAt(i)!=')'){
                        continue;
                    }
                    String newStr=str.substring(0,i)+str.substring(i+1,str.length());
                    if (queueVisit.contains(newStr)){
                        continue;
                    }
                    if (isValid(newStr)){
                        if (!visit.contains(newStr)){
                            result.add(newStr);
                            visit.add(newStr);
                            found=true;
                        }
                    }
                    queueVisit.add(newStr);
                    queue.offer(newStr);
                }
            }
        }
        if (result.size()==0){
            result.add("");
        }
        return result;
    }

    public boolean isValid(String s){
        int count=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                count++;
            }else if (s.charAt(i)==')'){
                count--;
                if (count<0){
                    return false;
                }
            }
        }
        return count==0;
    }

    public static void main(String[] args) {
        LeetCode301 l=new LeetCode301();
        System.out.println(l.removeInvalidParentheses("()())()"));
    }
}