package leetcode;

/**
 * @Author ROKG
 * @Description 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * @Date: Created in 2018/9/12
 * @Modified By: *
 */
public class LeetCode306 {

    // 先确定两个数找第三个数
    public boolean isAdditiveNumber(String num) {
        if (num.length()<3){
            return false;
        }
        for (int i=1;i<=num.length()-2;i++){
            String num1=num.substring(0, i);
            for (int j=i+1;j<=num.length()-1;j++){
                String num2=num.substring(i,j);
                String num3=num.substring(j);
                if (dfs(num1, num2, num3)){
                    return true;
                }
                if (num.charAt(i)=='0'){
                    break;
                }
            }
            if (num.charAt(0)=='0'){
                break;
            }
        }
        return false;
    }

    public boolean dfs(String num1,String num2,String num3){
        if (num3.length()==0){
            return true;
        }
        String sum=sum(num1, num2);
        for (int i=1;i<=num3.length();i++){
            String str=num3.substring(0, i);
            if (str.equals(sum)&&dfs(num2, str, num3.substring(i))){
                return true;
            }
            if (num3.charAt(0)=='0'){
                break;
            }
        }
        return false;
    }

    // 两个数求和防止数字过大使用字符串形式
    public String sum(String num1,String num2){
        int val=0,flag=0;
        int len1=num1.length(),len2=num2.length();
        String s="";
        while (len1>0||len2>0){
            val=0;
            if (len1>0){
                val+=num1.charAt(len1-1)-'0';
                len1--;
            }
            if (len2>0){
                val+=num2.charAt(len2-1)-'0';
                len2--;
            }
            s=(val+flag)%10+s;
            flag=(val+flag)/10;
        }
        if (flag>0){
            s=1+s;
        }
        return s;
    }

    public static void main(String[] args) {
        LeetCode306 l=new LeetCode306();
        System.out.println(l.isAdditiveNumber("198019823962"));
    }
}
