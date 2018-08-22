package leetcode;

/**
 * @Author ROKG
 * @Description 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。
 * @Date: Created in 下午1:43 2018/8/19
 * @Modified By: *
 */
public class LeetCode467 {

    // 相同开头字母的子串，长度更长的一定包含长度短的所有可能
    public static int findSubstringInWraproundString(String p) {
        if (p.length()==0){
            return 0;
        }
        int res=0;
        int[] flag= new int[26];
        char[] cc=p.toCharArray();
        for (int i=0;i<cc.length-1;i++){
            int j=i,count=1;
            while (j<cc.length-1&&(cc[j+1]-cc[j]==1||cc[j]-cc[j+1]==25)){
                j++;
                count++;
            }
            flag[cc[i]-'a']=Math.max(flag[cc[i]-'a'],count);
        }
        if (flag[cc[cc.length-1]-'a']==0){
            flag[cc[cc.length-1]-'a']=1;
        }
        for (int i=0;i<flag.length;i++){
            res+=flag[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("abaab"));
    }
}
