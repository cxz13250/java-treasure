package leetcode;

/**
 * @Author ROKG
 * @Description 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位， widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 * @Date: Created in 2018/9/3
 * @Modified By:
 */
public class LeetCode806 {

    public static int[] numberOfLines(int[] widths, String S) {
        int[] res=new int[2];
        if (S==null||S.length()==0){
            return res;
        }
        char[] cc=S.toCharArray();
        int count=1;
        int temp=0;
        for (char c:cc){
            if (temp+widths[c-'a']>100){
                count++;
                temp=0;
            }
            temp += widths[c-'a'];
        }
        res[0]=count;
        res[1]=temp;
        return res;
    }

    public static void main(String[] args) {
        numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz");
    }
}
