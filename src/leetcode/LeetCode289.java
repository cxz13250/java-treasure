package leetcode;

/**
 * @Author ROKG
 * @Description 生命游戏
 * @Date: Created in 下午10:26 2018/6/16
 * @Modified By: *
 */
public class LeetCode289 {

    int[][] dirs=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public void gameOfLife(int[][] board) {
        if (board.length==0){
            return;
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int count=0;
                for (int k=0;k<8;k++){
                    int x=i+dirs[k][0];
                    int y=j+dirs[k][1];
                    if (x<0 || x>=board.length || y<0 || y>=board[0].length){
                        continue;
                    }
                    count+=board[x][y]&1;
                }
                if (count==3){
                    board[i][j]=2+board[i][j];
                }else if (count==2){
                    board[i][j]=(board[i][j]<<1)+board[i][j];
                }
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                board[i][j]=(board[i][j]>>>1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode289 l=new LeetCode289();
        int[][] ins=new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        l.gameOfLife(ins);
        for (int i=0;i<ins.length;i++){
            for (int j=0;j<ins[0].length;j++){
                System.out.print(ins[i][j]);
            }
            System.out.println();
        }
    }
}
