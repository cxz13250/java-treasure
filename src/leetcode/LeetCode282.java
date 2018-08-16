package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 * @Date: Created in 2018/8/16
 * @Modified By: **
 */
public class LeetCode282 {

    List<String> result=new ArrayList<>();

    // 深度优先搜索,如果是*
    public List<String> addOperators(String num, int target) {
        if (num==null||num.length()==0){
            return result;
        }
        check(num,-Long.valueOf(target) ,"" , 0, 0, 1);
        return result;
    }

    public void check(String num, long sum, String res, int pos, long pre, long val){
        pre=pre*10+num.charAt(pos)-'0';
        if (sum>Integer.MAX_VALUE){
            return;
        }
        if (sum+pre*val==0&&pos==num.length()-1){
            result.add(res+num.charAt(pos));
        }
        if (pos==num.length()-1){
            return;
        }
        if (pre>0){  //非0数字可以保留到下一次递归
            check(num,sum ,res+num.charAt(pos) ,pos+1 , pre, val);
        }
        check(num,sum+pre*val,res+num.charAt(pos)+"+" ,pos+1 ,0 ,1);
        check(num,sum+pre*val,res+num.charAt(pos)+"-" ,pos+1 ,0 ,-1);
        check(num,sum,res+num.charAt(pos)+"*" ,pos+1 ,0 ,pre*val);
    }

    public static void main(String[] args) {
        LeetCode282 l =new LeetCode282();
        System.out.println(l.addOperators("2147483648" ,-2147483648));
    }
}
