package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * @Date: Created in 下午3:02 2018/5/8
 * @Modified By:
 */
public class LeetCode821 {

    public int[] shortestToChar(String S, char C) {
        int[] result=new int[S.length()];
        for (int i=0;i<S.length();i++){
            if(S.charAt(i)==C){
                result[i]=0;
            }else {
                int j=i-1;
                int left=-1;int right=-1;
                while (j>=0){
                    if(S.charAt(j)==C){
                        left=i-j;
                        break;
                    }
                    j--;
                }
                int k=i+1;
                while (k<S.length()){
                    if(S.charAt(k)==C){
                        right=k-i;
                        break;
                    }
                    k++;
                }
                if (left!=-1&&right!=-1){
                    result[i]=Math.min(left,right);
                }else if(left==-1){
                    result[i]=right;
                }else if(right==-1){
                    result[i]=left;
                }
            }
        }
        return result;
    }
}
