package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * @Date: Created in 下午9:36 2018/4/10
 * @Modified By:
 */
public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        char[] cc=s.toCharArray();
        int[][] arr=new int[cc.length][128];
        int max=0;
        for(int i=0;i<cc.length;i++){
            int temp=0;
            for(int j=i;j<cc.length;j++){
                if(arr[i][cc[j]]==0){
                    arr[i][cc[j]]++;
                    temp++;
                }else {
                    break;
                }
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s1="c";
        String s2="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
