package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列
 * @Date: Created in 下午10:52 2018/4/30
 * @Modified By:
 */
public class LeetCode521 {

    public int findLUSlength(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) {
            return Math.max(lenA, lenB);
        }else if (!a.equals(b)) {
            return lenA;
        }else {
            return -1;
        }
    }
}
