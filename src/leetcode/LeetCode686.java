package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * @Date: Created in 下午3:20 2018/5/5
 * @Modified By:
 */
public class LeetCode686 {

    public int repeatedStringMatch(String A, String B) {
        int i = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.toString().indexOf(B) == -1) {
            if(i>2&&sb.toString().length()>B.length()){
                return -1;
            }
            sb.append(A);
            i++;
        }
        return i;
    }
}
