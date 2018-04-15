package employee;

/**
 * @Author ROKG
 * @Description KMP模式匹配，时间复杂度O(m+n)
 * @Date: Created in 下午2:10 2018/4/4
 * @Modified By:
 */
public class KMP {

    private int[] next;

    /**
     * 普通字符串匹配
     * @param s
     * @param p
     * @return
     */
    public int violentMatch(String s,String p){
        char[] chars=s.toCharArray();
        char[] charp=p.toCharArray();
        int i = 0;
        int j = 0;
        while (i<chars.length&&j<charp.length){
            if(chars[i]==charp[j]){
                i++;
                j++;
            }else {
                i=i-(j-1);
                j=0;
            }
        }
        if(j==charp.length){
            return i-j;
        }else {
            return -1;
        }
    }

    /**
     * kmp模式匹配算法实现
     * @param s
     * @param p
     * @return
     */
    public int kmpMatch(String s,String p){
        char[] chars=s.toCharArray();
        char[] charp=p.toCharArray();
        this.next=next(charp);
        int i = 0;
        int j = 0;
        while (i<chars.length&&j<charp.length){
            if(j==-1 || chars[i]==charp[j] ){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==charp.length){
            return i-j;
        }else {
            return -1;
        }
    }

    /**
     * 生成next数组
     * @param p
     */
    public int[] next(char[] p){
        int[] next=new int[p.length];
        int k=-1;
        int j=0;
        next[0]=-1;
        while (j<p.length-1){
            if(k==-1 || p[j]==p[k]){
                k++;
                j++;
                next[j]=k;
            }else {
                k=next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp=new KMP();
        String a = "ababa";
        String b = "ssdfgasdbababa";
        System.out.println("普通匹配结果:"+kmp.violentMatch(b,a));
        System.out.println("kmp模式匹配结果:"+kmp.kmpMatch(b,a));
    }
}
