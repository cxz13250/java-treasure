package leetcode;

import java.util.Stack;

/**
 * @Author ROKG
 * @Description 你现在是棒球比赛记录员。给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * @Date: Created in 下午9:13 2018/5/4
 * @Modified By:
 */
public class LeetCode682 {

    public int calPoints(String[] ops) {
        int result=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<ops.length;i++){
            if(isNumber(ops[i])){
                result+=Integer.parseInt(ops[i]);
                stack.push(Integer.parseInt(ops[i]));
            }else if(needBack(ops[i])){
                result-=stack.pop();
            }else if(needDouble(ops[i])){
                result+=2*stack.peek();
                stack.push(stack.peek()*2);
            }else if(needAdd(ops[i])){
                int temp=stack.pop();
                int temp1=temp+stack.peek();
                result+=(temp+stack.peek());
                stack.push(temp);
                stack.push(temp1);
            }
        }
        return result;
    }

    public boolean isNumber(String str){
        if(!str.equals("C")&&!str.equals("D")&&!str.equals("+")){
            return true;
        }
        return false;
    }

    public boolean needBack(String str){
        if(str.equals("C")){
            return true;
        }
        return false;
    }

    public boolean needDouble(String str){
        if(str.equals("D")){
            return true;
        }
        return false;
    }
    public boolean needAdd(String str){
        if(str.equals("+")){
            return true;
        }
        return false;
    }
}
