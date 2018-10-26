package omega;

public class Board {

    public static int[][] BoardCopy(int[][] board) {
        int[][] newBoard=new int[9][9];

        for (int y=0; y<9; y++) {
            for (int x=0; x<9; x++) {
                newBoard[x][y]=board[x][y];
            }
        }

        return newBoard;
    }

    public static boolean hasEmpty(int[][] board) {
        for (int x=0; x<9; x++) {
            for (int y=0; y<9; y++) {
                if (board[x][y]==0) {
                    return true;
                }
            }
        }

        return false;
    }
}
