package leetcode;

/**
 * @Author ROKG
 * @Description 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
 * 字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
 * 字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
 * 如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * 并且每个组中 '1' 或 '2' 的出现次数分别是：
 * 1 2 2 1 1 2 1 2 2 1 2 2 ......
 * 你可以看到上面的出现次数就是 S 本身。
 * 给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
 * @Date: Created in 下午5:03 2018/7/8
 * @Modified By:
 */
public class LeetCode481 {

    public static int magicalString(int n) {
        if (n==0){
            return 0;
        }
        if (n<=3){
            return 1;
        }
        StringBuilder sb=new StringBuilder();
        sb.append("122");
        int i=3;
        int result=1;
        int j=2;
        while (i<n){
            char c=sb.charAt(i-1)=='1'?'2':'1';
            int add=sb.charAt(j)-'0';
            while (add>0){
                sb.append(c);
                i++;
                add--;
                if (c=='1'){
                    result++;
                }
                if (i>=n){
                    break;
                }
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(magicalString(8));
    }
}
