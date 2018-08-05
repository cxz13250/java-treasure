package leetcode;

/**
 * @Author ROKG
 * @Description 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * @Date: Created in 下午3:37 2018/7/29
 * @Modified By: *
 */
public class LeetCode91 {

    public static int numDecodings(String s) {
        if (s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int[] res=new int[s.length()];
        res[0]=1;
        if (Integer.valueOf(s.substring(0,2))<=26&&Integer.valueOf(s.substring(0,2))>=10){
            if (Integer.valueOf(s.substring(0,2))%10==0){
                res[1]=1;
            }else {
                res[1]=2;
            }
        }else {
            if (Integer.valueOf(s.substring(0,2))%10==0){
                res[1]=0;
            }else {
                res[1]=1;
            }
        }
        for (int i=2;i<s.length();i++){
            int cur=Integer.valueOf(s.substring(i,i+1));
            int pre=Integer.valueOf(s.substring(i-1,i));
            if (cur!=0){
                res[i]+=res[i-1];
            }
            if (pre>=10&&pre<=26){
                res[i]+=res[i-2];
            }
        }
        return res[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
