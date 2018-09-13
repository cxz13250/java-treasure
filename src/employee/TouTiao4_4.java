package employee;

import java.util.Scanner;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:27 2018/9/9
 * @Modified By:
 */
public class TouTiao4_4 {

    static int[][][] RULES={{{0,127}},
            {{192,223}, {128,191}},
            {{214,239},{128,191},{128,191}},
            {{240,247},{128,191},{128,191},{128,191}}};

    public static boolean check(int[] nums){
        int[][] RULE=RULES[nums.length-1];
        for (int i=0;i<nums.length;i++){
            int temp=nums[i]&255;
            int[] RULE_I=RULE[i];
            if (temp<RULE_I[0]||temp>RULE_I[1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] nums=new int[len];
        for (int i=0;i<len;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(check(nums)?1:0);
    }
}
