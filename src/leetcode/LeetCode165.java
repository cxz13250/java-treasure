package leetcode;

/**
 * @Author ROKG
 * @Description 比较两个版本号 version1 和 version2。如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * @Date: Created in 下午3:15 2018/5/4
 * @Modified By: *
 */
public class LeetCode165 {

    public static int compareVersion(String version1, String version2) {
        int i=0,j=0;
        while (i<version1.length()&&j<version2.length()){
            int sum1=0,sum2=0;
            while (i<version1.length()&&version1.charAt(i)!='.'){
                sum1=sum1*10+version1.charAt(i)-'0';
                i++;
            }
            while (j<version2.length()&&version2.charAt(j)!='.'){
                sum2=sum2*10+version2.charAt(j)-'0';
                j++;
            }
            if(sum1>sum2){
                return 1;
            }else if(sum1<sum2) {
                return -1;
            }
            i++;
            j++;
        }
        if(i<version1.length()){
            // 为了处理"1.0"与"1"
            while (i<version1.length()&&(version1.charAt(i)=='.'||version1.charAt(i)=='0')){
                i++;
            }
            if(i<version1.length()){
                return 1;
            }
        }else if(j<version2.length()){
            while (j<version2.length()&&(version2.charAt(j)=='.'||version2.charAt(j)=='0')){
                j++;
            }
            if(j<version2.length()){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1","1.1"));
    }
}
