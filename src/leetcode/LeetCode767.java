package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * @Date: Created in 2018/9/26
 * @Modified By: *
 */
public class LeetCode767 {

    // 如果某个字符出现次数大于S总长度/2+1，则一定不可行
    // 如果存在某个字符的出现次刚好等于S总长度/2+1，那必须从0开始放置
    public static String reorganizeString(String S) {
        int[] cc=new int[26];
        char[] ss=S.toCharArray();
        char[] res=new char[S.length()];
        int max=0;
        for (char c:ss){
            cc[c-'a']++;
            max=Math.max(max, cc[c-'a']);
        }
        if (2*max-1>S.length()){
            return "";
        }
        int odd=0,even=1;
        for (int i=0;i<26;i++){
            while (cc[i]>0&&cc[i]<S.length()/2+1&&even<S.length()){
                res[even]=(char)('a'+i);
                even+=2;
                cc[i]--;
            }
            while (cc[i]>0){
                res[odd]+=(char)('a'+i);
                odd+=2;
                cc[i]--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aabb"));
    }
}
