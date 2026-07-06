import java.security.SecureRandom;

public class KnightsTour {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] board = new int[8][8];
    static int[][] accessibility = {
        {2, 3, 4, 4, 4, 4, 3, 2},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {2, 3, 4, 4, 4, 4, 3, 2}
    };
    static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int currentRow = 0;
        int currentCol = 0;
        int moveNumber = 0;
        board[currentRow][currentCol] = ++moveNumber;

        while (moveNumber < 64) {
            int minAccess = 9;
            int bestMove = -1;
            int bestRow = 0;
            int bestCol = 0;

            for (int move = 0; move < 8; move++) {
                int nextRow = currentRow + vertical[move];
                int nextCol = currentCol + horizontal[move];

                if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
                    if (board[nextRow][nextCol] == 0) {
                        if (accessibility[nextRow][nextCol] < minAccess) {
                            minAccess = accessibility[nextRow][nextCol];
                            bestMove = move;
                            bestRow = nextRow;
                            bestCol = nextCol;
                        }
                    }
                }
            }

            if (bestMove == -1) {
                break;
            }

            accessibility[currentRow][currentCol] = 0;
            currentRow = bestRow;
            currentCol = bestCol;
            board[currentRow][currentCol] = ++moveNumber;
        }

        System.out.println("The knight made " + moveNumber + " moves.");
        displayBoard();
    }

    public static void displayBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.printf("%3d", board[r][c]);
            }
            System.out.println();
        }
    }
}
