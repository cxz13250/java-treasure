package leetcode;

/**
 * @Author ROKG
 * @Description 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * @Date: Created in 下午10:21 2018/4/21
 * @Modified By:
 */
public class LeetCode423 {

    public static String originalDigits(String s) {
        int[] count=new int[26];
        char[] cc=s.toCharArray();
        for(char c:cc){
            count[c-'a']++;
        }
        int[] result=new int[10];
        result[0]=count['z'-'a'];
        result[2]=count['w'-'a'];
        result[4]=count['u'-'a'];
        result[6]=count['x'-'a'];
        result[8]=count['g'-'a'];
        result[1]=count['o'-'a']-result[0]-result[2]-result[4];
        result[3]=count['h'-'a']-result[8];
        result[5]=count['f'-'a']-result[4];
        result[7]=count['v'-'a']-result[5];
        result[9]=count['i'-'a']-result[5]-result[6]-result[8];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i];i++){
                sb.append((char)('0'+i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
    }
}
