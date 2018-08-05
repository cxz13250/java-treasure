package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个Excel表格中的列名称，返回其相应的列序号。
 * @Date: Created in 下午11:34 2018/8/1
 * @Modified By:
 */
public class LeetCode171 {

    public static int titleToNumber(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        int len=s.length();
        int res=0;
        for (int i=0;i<s.length();i++){
            res+=Math.pow(26,len-i-1)*(s.charAt(i)-'A'+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
