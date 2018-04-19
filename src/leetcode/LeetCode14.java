package leetcode;

/**
 * @Author ROKG
 * @Description 求字符串数组的最长公共前缀
 * @Date: Created in 下午10:30 2018/4/15
 * @Modified By:
 */
public class LeetCode14 {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        char[][] cc=new char[strs.length][];
        int max=0;
        for(int i=0;i<strs.length;i++){
            max=Math.max(max,strs[i].length());
            cc[i]=strs[i].toCharArray();
        }
        for(int i=0;i<max;i++){
            if(i>=cc[0].length){
                break;
            }
            char temp=cc[0][i];
            for(int j=1;j<cc.length;j++){
                if(i>=cc[j].length){
                    return sb.toString();
                }
                if(cc[j][i]!=temp){
                    return sb.toString();
                }
            }
            sb.append(cc[0][i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings={"abc","abd","aba"};
        System.out.println(longestCommonPrefix(strings));
        String[] strings1={"","b"};
        System.out.println(longestCommonPrefix(strings1));
    }
}
