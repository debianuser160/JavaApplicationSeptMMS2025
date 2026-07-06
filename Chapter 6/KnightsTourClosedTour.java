public class KnightsTourClosedTour {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        int startRow = 0;
        int startCol = 0;
        int currentRow = startRow;
        int currentCol = startCol;
        int moveNumber = 1;
        board[currentRow][currentCol] = moveNumber;

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
                        int access = getAccessibility(board, nextRow, nextCol);
                        if (access < minAccess) {
                            minAccess = access;
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

            currentRow = bestRow;
            currentCol = bestCol;
            board[currentRow][currentCol] = ++moveNumber;
        }

        System.out.println("The knight made " + moveNumber + " moves.");

        if (moveNumber == 64) {
            boolean isClosedTour = false;
            for (int move = 0; move < 8; move++) {
                int nextRow = currentRow + vertical[move];
                int nextCol = currentCol + horizontal[move];
                if (nextRow == startRow && nextCol == startCol) {
                    isClosedTour = true;
                    break;
                }
            }

            if (isClosedTour) {
                System.out.println("It is a CLOSED tour!");
            } else {
                System.out.println("It is a full tour but NOT closed.");
            }
        }

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.printf("%3d", board[r][c]);
            }
            System.out.println();
        }
    }

    public static int getAccessibility(int[][] board, int row, int col) {
        int count = 0;
        for (int move = 0; move < 8; move++) {
            int nextRow = row + vertical[move];
            int nextCol = col + horizontal[move];
            if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
                if (board[nextRow][nextCol] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
