package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @Date: Created in 下午11:15 2018/5/24
 * @Modified By: *
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        StringBuffer sb=new StringBuffer();
        int m=num1.length();
        int n=num2.length();
        int[] arr=new int[m+n];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                int index1=i+j;
                int index2=i+j+1;
                int sum=(num1.charAt(i)-'0')+(num2.charAt(j)-'0')+ arr[index2];
                arr[index1]+=sum/10;
                arr[index2]=sum%10;
            }
        }
        for (int i:arr){
            if (sb.length()!=0 || i!=0) {
                sb.append(i);
            }
        }
        return sb.length()>0?sb.toString():"0";
    }
}
