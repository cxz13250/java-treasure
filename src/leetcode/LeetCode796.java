package leetcode;

/**
 * @Author ROKG
 * @Description 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * @Date: Created in 上午12:51 2018/8/12
 * @Modified By:
 */
public class LeetCode796 {

    public static boolean rotateString(String A, String B) {
        if (A.equals(B)){
            return true;
        }
        char head=B.charAt(0);
        int index=-1;
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)==head){
                index=i;
                String newStr=A.substring(index)+A.substring(0,index);
                if (newStr.equals(B)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg";
        String s2="fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf";
        System.out.println(rotateString(s1,s2));
    }
}
