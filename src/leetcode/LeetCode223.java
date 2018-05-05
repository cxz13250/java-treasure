package leetcode;

/**
 * @Author ROKG
 * @Description 在二维平面上计算出两个由直线构成的矩形叠加覆盖后的面积。
 * 每个矩形由其左下顶点和右上顶点坐标表示
 * @Date: Created in 下午3:02 2018/5/2
 * @Modified By:
 */
public class LeetCode223 {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width1=C-A;
        int height1=D-B;
        int width2=G-E;
        int height2=H-F;
        if(B>H||C<E||A>G||D<F){
            return width1*height1+width2*height2;
        }
        int width=0;
        int height=0;
        for(int i=Math.min(A,E);i<Math.max(C,G);i++){
            if(i>=A&&i<=C&&i>=E&&i<=G){
                width++;
            }
        }
        for(int i=Math.min(B,F);i<=Math.max(D,H);i++){
            if(i>=B&&i<=D&&i>=F&&i<=H){
                height++;
            }
        }
        return width1*height1+width2*height2-(width-1)*(height-1);
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-2,-2,2,2,0,0,0,0));
    }
}
