package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ROKG
 * @Description 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @Date: Created in 下午2:34 2018/5/4
 * @Modified By:
 */
public class LeetCode130 {

    class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i=i;
            this.j=j;
        }
    }

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                check(board,i,0);
            }
            if(board[i][n-1]=='O'){
                check(board,i,n-1);
            }
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                check(board,0,i);
            }
            if(board[m-1][i]=='O'){
                check(board,m-1,i);
            }
        }

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void check(char[][] board,int i,int j){
        int m=board.length;
        int n=board[0].length;
        if (board[i][j]=='O') {
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(i, j));
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                if (board[p.i][p.j] != 'O') {
                    continue;
                } else {
                    board[p.i][p.j] = 'A';
                }
                if (p.i < m - 1 && board[p.i + 1][p.j] == 'O') {
                    queue.offer(new Point(p.i + 1, p.j));
                }
                if (p.i > 0 && board[p.i - 1][p.j] == 'O') {
                    queue.offer(new Point(p.i - 1, p.j));
                }
                if (p.j < n - 1 && board[p.i][p.j + 1] == 'O') {
                    queue.offer(new Point(p.i, p.j + 1));
                }
                if (p.j > 0 && board[p.i][p.j - 1] == 'O') {
                    queue.offer(new Point(p.i, p.j - 1));
                }
            }
        }
    }

}
