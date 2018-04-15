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
        char[] chars=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int sum=s.length();
        int col=(s.length()/(2*numRows-2))*2+2;
        int[][] arr=new int[numRows][col];
        int temp=1;
        for(int i=0;i<col;i++){
            if(i%2==0){
                for(int j=0;j<numRows;j++){
                    if(temp<=sum){
                        arr[j][i]=temp;
                        temp++;
                    }else {
                        break;
                    }
                }
            }else {
                for(int j=numRows-2;j>=1;j--){
                    if(temp<=sum){
                        arr[j][i]=temp;
                        temp++;
                    }else {
                        break;
                    }
                }
            }
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]!=0){
                    sb.append(chars[arr[i][j]-1]);
                }
            }
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
