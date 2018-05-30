package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @Date: Created in 下午11:15 2018/5/24
 * @Modified By: *
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        return int2string(string2int(num1)*string2int(num2));
    }

    public long string2int(String str){
        long result=0;
        for (int i=0;i<str.length();i++){
            result=result*10+str.charAt(i)-'0';
        }
        return result;
    }

    public String int2string(long i){
        if (i==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        while (i!=0){
            sb.insert(0,i%10);
            i/=10;
        }
        return sb.toString();
    }

    public static void main(String[] args)throws Exception {

    }
}
