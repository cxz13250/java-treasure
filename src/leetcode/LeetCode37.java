package leetcode;

/**
 * @Author ROKG
 * @Description  解数独
 * @Date: Created in 下午10:11 2018/6/7
 * @Modified By: *
 */
public class LeetCode37 {

    boolean[][] row=new boolean[9][9];
    boolean[][] col=new boolean[9][9];
    boolean[][] grid=new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    int temp=board[i][j]-'0'-1;
                    row[i][temp]=true;
                    col[j][temp]=true;
                    grid[i/3*3+j/3][temp]=true;
                }
            }
        }
        solveSudoku(board,0);
    }

    public boolean solveSudoku(char[][] board,int index) {
        int x=index/9;
        int y=index%9;
        if (board[x][y]=='.'){
            for (int i=0;i<9;i++) {
                if (row[x][i]||col[y][i]||grid[x/3*3+y/3][i]) {
                    continue;
                }else {
                    row[x][i]=true;
                    row[y][i]=true;
                    grid[x/3*3+y/3][i]=true;
                    board[x][y]=(char)('0'+i+1);
                    if (index==80){
                        return true;
                    }
                    if (!solveSudoku(board,index+1)){
                        row[x][i]=false;
                        row[y][i]=false;
                        grid[x/3*3+y/3][i]=false;
                        board[x][y]='.';
                    }else {
                        return true;
                    }
                }
            }
            return false;
        }else {
            if (index==80){
                return true;
            }
            return solveSudoku(board,index+1);
        }
    }
}
