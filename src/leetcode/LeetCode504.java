package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * @Date: Created in 下午10:20 2018/5/17
 * @Modified By:
 */
public class LeetCode504 {

    public String convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        int temp=Math.abs(num);
        while (temp>0){
            int i=temp%7;
            temp/=7;
            sb.append(""+i);
        }
        if (num<0){
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
