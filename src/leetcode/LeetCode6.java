package leetcode;

/**
 * @Author ROKG
 * @Description 将字符串以Z字形排列成给定的行数,之后从左往右，逐行读取字符
 * @Date: Created in 下午10:57 2018/4/12
 * @Modified By:
 */
public class LeetCode6 {

    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[] cc=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cc.length;i+=2*numRows-2){
            sb.append(cc[i]);
        }
        for(int i=1;i<numRows-1;i++){
            int j=i;
            while(j<cc.length){
                sb.append(cc[j]);
                // 第i行，跨越step为2*(numRows-i)-2
                j+=2*(numRows-i)-2;
                if(j<cc.length){
                    sb.append(cc[j]);
                    j+=2*i;
                }
            }
        }
        for(int i=numRows-1;i<cc.length;i+=2*numRows-2){
            sb.append(cc[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s1="ABCDE";
        System.out.println(convert(s1,4));
        String s2="PAYPALISHIRING";
        System.out.println(convert(s2,3));
    }
}
