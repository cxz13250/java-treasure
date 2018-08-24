package leetcode;

import java.util.Arrays;

/**
 * @Author ROKG
 * @Description 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * @Date: Created in 2018/8/22
 * @Modified By: *
 */
public class LeetCode354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==0 || envelopes[0].length==0){
            return 0;
        }
        Arrays.sort(envelopes, (a,b)-> {
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }else {
                return b[1]-a[1];
            }
        });
        int[] flag=new int[envelopes.length];
        int res=0;
        for (int i=0;i<flag.length;i++){
            int[] temp=envelopes[i];
            int index=Arrays.binarySearch(flag, 0,res,temp[1]);
            if (index<0){
                index = -(index+1);
            }
            flag[index]=temp[1];
            if (index==res){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode354 l=new LeetCode354();
        System.out.println(l.maxEnvelopes(new int[][]{{46,89},{50,53},{52,68},{72,45},{77,81}}));
    }
}
