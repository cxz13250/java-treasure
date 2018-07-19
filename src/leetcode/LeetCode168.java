package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * @Date: Created in 下午9:35 2018/7/3
 * @Modified By: *
 */
public class LeetCode168 {

    public static String convertToTitle(int n) {
        StringBuilder result=new StringBuilder();
        while (n!=0){
            int temp=(n-1)%26;
            result.append((char)('A'+temp));
            n=(n-1)/26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
