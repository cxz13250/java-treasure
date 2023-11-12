package leetcode;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:07 2020/5/24
 * @Modified By:
 */
public class LeetCode999 {

    public int numRookCaptures(char[][] board) {
        int res=0;
        int[] mx=new int[]{-1,1,0,0};
        int[] my=new int[]{0,0,-1,1};
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                int x=i,y=j;
                if (board[x][y]=='R') {
                    for (int k = 0; k < 4; k++) {
                        x+=mx[k];
                        y+=my[k];
                        if (x<0||y<0||x>=8||y>=8||board[x][y]=='B'){
                            break;
                        }
                        if (board[x][y]=='p'){
                            res++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }
}
