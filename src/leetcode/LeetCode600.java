package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。 1 <= n <= 109
 * @Date: Created in 2018/7/17
 * @Modified By: *
 */
public class LeetCode600 {

    public static int findIntegers(int num) {
        String s = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
        int[] zero = new int[s.length()];
        int[] one = new int[s.length()];
        zero[0] = 1;
        one[0] = 1;
        for (int i = 1;i < s.length();i++){
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }
        int res = zero[s.length() - 1] + one[s.length() - 1];
        for (int i = s.length()-2;i >= 0;i--){
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1'){
                break;
            }else if (s.charAt(i) == '0' && s.charAt(i + 1) == '0'){
                res -= one[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findIntegers(8));
    }
}
