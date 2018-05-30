package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * @Date: Created in 下午5:02 2018/5/26
 * @Modified By: *
 */
public class LeetCode166 {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        if ((numerator>0&&denominator<0)||(numerator<0&&denominator>0)){
            sb.append("-");
        }
        long num=Math.abs(numerator);
        if (numerator==Integer.MIN_VALUE){
            num=(long)Integer.MAX_VALUE+1;
        }
        long dem=Math.abs(denominator);
        if (denominator==Integer.MIN_VALUE){
            dem=(long)Integer.MAX_VALUE+1;
        }
        long intL=num/dem;
        long remL=num%dem;
        sb.append(intL);
        if (remL==0){
            return sb.toString();
        }else {
            sb.append(".");
            int count=sb.length();
            Map<Long,Integer> map=new HashMap<>();
            while (remL!=0){
                if (map.containsKey(remL)){
                    sb.insert(map.get(remL),"(");
                    sb.append(')');
                    break;
                }
                map.put(remL,count++);
                remL*=10;
                sb.append(remL/dem);
                remL%=dem;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2,1));
        System.out.println(fractionToDecimal(1,6));
        System.out.println(fractionToDecimal(2,3));
        System.out.println(fractionToDecimal(4,333));
    }
}
