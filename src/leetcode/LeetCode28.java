package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @Date: Created in 下午12:37 2018/4/22
 * @Modified By:
 */
public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        char[] cone=haystack.toCharArray();
        char[] ctwo=needle.toCharArray();
        int[] next=next(ctwo);
        int i=0;
        int j=0;
        while (i<haystack.length()&&j<needle.length()){
            if(j==-1||cone[i]==ctwo[j]){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==ctwo.length){
            return i-j;
        }else {
            return -1;
        }
    }

    public int[] next(char[] cc){
        int[] next=new int[cc.length];
        int k=-1;
        int j=0;
        next[j]=k;
        while (j<cc.length){
            if(k==-1 || cc[j]==cc[k]){
                j++;
                k++;
                next[j]=k;
            }else {
                k=next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {

    }
}
