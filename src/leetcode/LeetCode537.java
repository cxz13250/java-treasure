package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个表示复数的字符串。
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * @Date: Created in 2018/8/7
 * @Modified By:
 */
public class LeetCode537 {

    public static String complexNumberMultiply(String a, String b) {
        String[] sA=a.split("\\+");
        String[] sB=b.split("\\+");
        int numA1=Integer.parseInt(sA[0]);
        int numB1=Integer.parseInt(sB[0]);
        int numA2=Integer.parseInt(sA[1].substring(0,sA[1].length()-1));
        int numB2=Integer.parseInt(sB[1].substring(0,sB[1].length()-1));
        int res1=numA1*numB1-numA2*numB2;
        int res2=numA1*numB2+numA2*numB1;
        StringBuilder result=new StringBuilder();
        result.append(res1);
        result.append("+");
        result.append(res2);
        result.append("i");
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("-1"));
        System.out.println(complexNumberMultiply("1+1i","1+1i"));
        System.out.println(complexNumberMultiply("1+-1i","1+-1i"));
    }
}
