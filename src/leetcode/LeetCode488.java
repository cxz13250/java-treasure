package leetcode;

/**
 * @Author ROKG
 * @Description 回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。
 * 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它们移除掉。重复这一步骤直到桌上所有的球都被移除。
 * 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。
 * @Date: Created in 上午10:00 2018/8/28
 * @Modified By:
 */
public class LeetCode488 {

    public int findMinStep(String board, String hand) {
        int[] nums=new int[128];
        for (char c:hand.toCharArray()){
            ++nums[c];
        }
        return dfs(board,nums);
    }

    public int dfs(String board,int[] nums){
        if (board==null||board.length()==0){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        int i=0,j=0;
        while (i<board.length()){
            while (j<board.length()&&board.charAt(i)==board.charAt(j)){
                ++j;
            }
            char color=board.charAt(i);
            int b=3-(j-i); //b只能是1或2
            if (nums[color]>=b){
                String nb=update(board.substring(0,i)+board.substring(j));
                nums[color]-=b;
                int r=dfs(nb,nums);
                if (r>=0){
                    res=Math.min(res,r+b);
                }
                nums[color]+=b;
            }
            i=j;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    public String update(String board){
        int i=0;
        while (i<board.length()){
            int j=i;
            while (j<board.length()&&board.charAt(i)==board.charAt(j)){
                ++j;
            }
            if (j-i>=3){
                board=board.substring(0,i)+board.substring(j);
                i=0;
            }else {
                i++;
            }
        }
        return board;
    }

    public static void main(String[] args) {
        LeetCode488 l=new LeetCode488();
        System.out.println(l.findMinStep("RBYYBBRRB","YRBGB"));
        System.out.println(l.findMinStep("WRRBBW","RB"));
    }
}
