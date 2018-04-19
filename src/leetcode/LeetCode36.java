package leetcode;

/**
 * @Author ROKG
 * @Description 判断一个 9x9 的数独是否有效。
 * @Date: Created in 下午10:26 2018/4/18
 * @Modified By:
 */
public class LeetCode36 {

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] grid=new boolean[9][9];

        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int temp=board[i][j]-'0'-1;
                if(row[i][temp] || col[j][temp] || grid[i/3*3+j/3][temp]){
                    return false;
                }
                row[i][temp]=true;
                col[j][temp]=true;
                grid[i/3*3+j/3][temp]=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] cc= {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(cc));
    }
}
