package leetcode;

/**
 * @Author ROKG
 * @Description 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * 返回任意一种符合条件的字符串T。
 * @Date: Created in 上午12:28 2018/8/15
 * @Modified By:
 */
public class LeetCode791 {

    public static String customSortString(String S, String T) {
        if (T==null || T.length()==0 || S==null || S.length()==0){
            return T;
        }
        char[] s=S.toCharArray();
        char[] t=T.toCharArray();
        int[] nums=new int[s.length];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<t.length;i++){
            if (S.indexOf(t[i])>-1){
                nums[S.indexOf(t[i])]++;
            }else {
                sb.append(t[i]);
            }
        }
        for (int i=nums.length-1;i>=0;i--){
            for (int j=0;j<nums[i];j++){
                sb.insert(0,s[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba","abcd"));
    }
}
