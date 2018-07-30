package leetcode;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 将非负整数转换为其对应的英文表示。可以保证给定输入小于 2^31 - 1 。
 * @Date: Created in 下午11:34 2018/6/7
 * @Modified By: *
 */
public class LeetCode273 {

    String[] underTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    String[] productTen = { "","","Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };
    String[] thousands = {"",  "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num==0){
            return "Zero";
        }
        int cur=num;
        int count=0;
        String result="";
        List<String> stringList=new ArrayList<>();
        while (cur>0){
            int per=cur/1000;
            int rest=cur%1000;
            if (per>0){
                count++;
            }
            stringList.add(check(rest));
            cur=per;
        }
        for (int i=count;i>0;i++){
            String s=stringList.get(i);
            if (s.trim().length()>0) {
                result = result + s + thousands[i] + " ";
            }
        }
        int end=result.length()-1;
        while (result.charAt(end)==' '){
            end--;
        }
        result=result.substring(0,end+1);
        return result;
    }

    public String check(int num){
        String res="";
        int hun=num/100;
        int huns=num%100;
        int ten=huns/10;
        int one=huns%10;
        if (hun>0){
            res+=underTwenty[hun]+" Hundred";
        }
        if (huns>0&&huns<20){
            res+=underTwenty[huns]+" ";
        }else if (ten!=0){
            res+=productTen[ten]+" "+(one>0?underTwenty[one]+" ":"");
        }
        return res;
    }
}
