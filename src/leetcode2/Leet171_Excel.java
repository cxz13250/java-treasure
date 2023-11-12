package leetcode2;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午3:55 2023/11/4
 * @Modified By:
 */
public class Leet171_Excel {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        int stage = 1;
        for (int i = columnTitle.length() - 1; i >= 0 ; i--) {
            // 取出当前这一位的值
            int value = (columnTitle.charAt(i) - 'A' + 1);
            res += stage * value;
            stage *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leet171_Excel().titleToNumber("ZY"));
    }
}
