package leetcode;

import java.util.Random;

/**
 * @Author ROKG
 * @Description Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
 * @Date: Created in 2018/9/13
 * @Modified By:
 */
public class LeetCode497 {

    int len;
    int[][] rects;
    int[] lens;
    Random random=new Random();

    public LeetCode497(int[][] rects) {
        this.rects=rects;
        this.lens=new int[rects.length];
        for (int i=0;i<rects.length;i++){
            int[] rect=rects[i];
            int x1=rect[0];
            int y1=rect[1];
            int x2=rect[2];
            int y2=rect[3];
            int tmp=(y2-y1+1)*(x2-x1+1);
            lens[i]=len;
            len+=tmp;
        }
    }

    public int[] pick() {
        int pos=random.nextInt(len);
        System.out.println(pos);
        int index=0;
        int i=0;
        for (;i<lens.length;i++){
            if (lens[i]>pos){
                break;
            }
        }
        index=i-1;
        pos-=lens[index];
        int[] rect=rects[index];
        int x1=rect[0];
        int y1=rect[1];
        int x2=rect[2];
        int y2=rect[3];
        int x=x1+pos%(x2-x1+1);
        int y=y1+pos/(x2-x1+1);
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        LeetCode497 l=new LeetCode497(new int[][]{{-2,-2,-1,-1},{1,0,3,0}});
        int[] nums=l.pick();
        System.out.println(nums[0]+" "+nums[1]);
        nums=l.pick();
        System.out.println(nums[0]+" "+nums[1]);
        nums=l.pick();
        System.out.println(nums[0]+" "+nums[1]);
        nums=l.pick();
        System.out.println(nums[0]+" "+nums[1]);
        nums=l.pick();
        System.out.println(nums[0]+" "+nums[1]);
    }
}
