package leetcode;

/**
 * @Author ROKG
 * @Description 用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 * 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
 * 以下是井字游戏的规则：
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * @Date: Created in 2018/8/22
 * @Modified By:
 */
public class LeetCode794 {

    public boolean validTicTacToe(String[] board) {
        char[][] cc=new char[3][3];
        for (int i=0;i<board.length;i++){
            cc[i]=board[i].toCharArray();
        }
        int countX=0,countO=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (cc[i][j]=='X'){
                    countX++;
                }else if (cc[i][j]=='O'){
                    countO++;
                }
            }
        }
        if (countO>countX || countX-countO>1){
            return false;
        }
        if (countX==countO){
            if (!check(cc, 'X')){
                return false;
            }
        }
        else if (countX-countO==1){
            if (!check(cc, 'O')){
                return false;
            }
        }
        return true;
    }

    public boolean check(char[][] cc,char ch){
        for (int i = 0; i < 3; i++) {
            if (cc[i][0] == ch && cc[i][0] == cc[i][1] && cc[i][1] == cc[i][2]) {
                return false;
            }
            if (cc[0][i] == ch && cc[0][i] == cc[1][i] && cc[1][i] == cc[2][i]) {
                return false;
            }
        }
        if (cc[0][0] == ch && cc[0][0] == cc[1][1] && cc[1][1] == cc[2][2]) {
            return false;
        }
        if (cc[0][2] == ch && cc[0][2] == cc[1][1] && cc[1][1] == cc[2][0]) {
            return false;
        }
        return true;
    }
}
