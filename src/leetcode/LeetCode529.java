package leetcode;

/**
 * @Author ROKG
 * @Description 扫雷游戏
 * @Date: Created in 下午11:44 2018/8/31
 * @Modified By: *
 */
public class LeetCode529 {

    private final char undefine='E';

    private final char boomed='X';

    private final char noboom='B';

    private final char hasboom='M';

    private int[] posx={-1, -1, -1,  0, 0,  1, 1, 1};

    private int[] posy={-1,  0,  1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int m=board.length;
        if (m==0){
            return board;
        }
        int n=board.length;
        if (n==0){
            return board;
        }
        check(board,click[0],click[1]);
        return board;
    }

    public void check(char[][] board,int x,int y) {
        if (x<0 || x>board.length || y<0 || y>board[0].length || (board[x][y] != undefine && board[x][y] != hasboom)) {
            return;
        }
        if (board[x][y] == hasboom) {
            board[x][y] = boomed;
            return;
        }
        int count=0;
        for (int i=0;i<8;i++){
            int row = x + posx[i];
            int col = y + posy[i];
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                continue;
            }if (board[row][col] == hasboom) {
                count++;
            }
        }
        if (count==0) {
            board[x][y]=noboom;
            for (int i=0;i<8;i++){
                int row = x + posx[i];
                int col = y + posy[i];
                if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                    continue;
                }
                check(board,row,col);
            }
        }else {
            board[x][y]=(char)('0'+count);
        }
    }

    public static void main(String[] args) {
        LeetCode529 l=new LeetCode529();
        l.updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}},new int[]{3,0});
    }
}
