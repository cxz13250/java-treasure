package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * @Date: Created in 下午10:14 2018/5/3
 * @Modified By:
 */
public class LeetCode476 {

    public int findComplement(int num) {
        String s=Integer.toBinaryString(num);
        char[] cc=s.toCharArray();
        int result=0;
        for(int i=0;i< cc.length;i++){
            if(cc[i]=='0'){
                result+=Math.pow(2,cc.length-i-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
    }
}
