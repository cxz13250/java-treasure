package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
 * 有效的运算符号包含 +, - 以及 * 。
 * @Date: Created in 下午11:49 2018/7/11
 * @Modified By: *
 */
public class LeetCode241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<input.length();i++){
            if (input.charAt(i)=='-'||input.charAt(i)=='*'||input.charAt(i)=='+'){
                List<Integer> left=diffWaysToCompute(input.substring(0,i));
                List<Integer> right=diffWaysToCompute(input.substring(i+1,input.length()));
                for (int l:left){
                    for (int r:right){
                        if (input.charAt(i)=='-'){
                            result.add(l-r);
                        }else if (input.charAt(i)=='+'){
                            result.add(l+r);
                        }else {
                            result.add(l*r);
                        }
                    }
                }
            }
        }
        if (result.size()==0){
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
