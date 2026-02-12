package Codewars;/*checks 4 possible cases:
-1 = The board is not yet finished AND no one has won
0 = The board is finished AND no one has won
1 = X won
2 = O won
*/

public class TicTacToeChecker {
    public static int isSolved(int[][] board) {

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            return board[0][0];
        } else if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != 0) {
            return board[2][0];
        } else {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                    return board[i][0];
                }
            }
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != 0) {
                    return board[0][j];
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
/*
case 1: [0][0] == [1][0] == [2][0] != 0
case 2: [0][1] == [1][1] == [2][1] != 0
case 3: [0][2] == [1][2] == [2][2] != 0
case 4: [0][0] == [0][1] == [0][2] != 0
case 5: [1][0] == [1][1] == [1][2] != 0
case 6: [2][0] == [2][1] == [2][2] != 0
case 7: [0][0] == [1][1] == [2][2] != 0
case 8: [2][0] == [1][1] == [0][2] != 0
 */