package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * @Date: Created in 下午8:01 2018/5/19
 * @Modified By:
 */
public class LeetCode696 {

    public int countBinarySubstrings(String s) {
        int result=0;
        int[] temp=new int[s.length()];
        temp[0]=1;
        int index=0;
        for (int i=0;i<s.length()-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                temp[index]++;
            }else {
                temp[++index]=1;
            }
        }
        for (int i=1;i<temp.length;i++){
            result+=Math.min(temp[i-1],temp[i]);
        }
        return result;
    }
}
