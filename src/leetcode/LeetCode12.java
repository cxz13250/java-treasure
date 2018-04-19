package leetcode;

/**
 * @Author ROKG
 * @Description 整数转罗马数字
 * @Date: Created in 下午10:21 2018/4/15
 * @Modified By:
 */
public class LeetCode12 {

    static String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    static int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};

    public static String intToRoman(int num) {
        StringBuilder result=new StringBuilder();
        int i=0;
        while (num>0){
            while (num<values[i]){
                i++;
            }
            result.append(romans[i]);
            num=num-values[i];
            i=0;
        }
        return result.toString();
    }


    public static void main(String[] args) {
        int i=1;
        System.out.println(intToRoman(i));
    }
}
