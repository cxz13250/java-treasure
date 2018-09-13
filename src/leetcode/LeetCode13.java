package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 罗马数字转整数
 * @Date: Created in 下午3:05 2018/4/15
 * @Modified By:
 */
public class LeetCode13 {

    static Map<Character,Integer> romanValues=new HashMap<Character, Integer>(){
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };

    public static int romanToInt(String s){
        char[] cc=s.toCharArray();
        int sum=0;
        int pre=-1;
        for(int i=0;i<cc.length;i++){
            int temp=romanValues.get(cc[i]);
            if(pre!=-1&&pre<temp){
                sum+=temp-2*pre;
            }else {
                sum+=temp;
            }
            pre=temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s="IIX";
        System.out.println(romanToInt(s));
    }
}
