package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午4:28 2023/11/12
 * @Modified By:
 */
public class Leet344_reverseString {


    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int length = s.length;
        for (int i = 0; i < s.length/2; i++) {
            swap(i, length - i - 1, s);
        }
    }

    public void swap(int left, int right, char[] s) {
        if (left == right) {
            return;
        }
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new Leet344_reverseString().reverseString(s);
        System.out.println(s);
    }
}
