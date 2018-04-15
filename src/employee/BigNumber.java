package employee;

/**
 * @Author ROKG
 * @Description 大数相乘 4234*3124
 * @Date: Created in 下午8:49 2018/4/10
 * @Modified By:
 */
public class BigNumber {

    public static void check(String s1,String s2){
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int[] result=new int[c1.length+c2.length];
        int[] r1=new int[c1.length];
        int[] r2=new int[c2.length];
        for(int i=0;i<c1.length;i++){
            r1[i]=c1[i]-'0';
        }
        for(int i=0;i<c2.length;i++){
            r2[i]=c2[i]-'0';
        }
        for(int i=0;i<c1.length;i++){
            for(int j=0;j<c2.length;j++){
                result[i+j]+=r1[i]*r2[j];
            }
        }
        for(int i=result.length-1;i>0;i--){
            result[i-1]+=result[i]/10;
            result[i]=result[i]%10;
        }
        for(int i=0;i<result.length-1;i++){
            System.out.print(result[i]);
        }
    }

    public static void main(String[] args) {
        check("4234","3124");
    }
}
