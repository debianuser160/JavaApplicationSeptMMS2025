public class EightQueens {
    static int[][] board = new int[8][8];
    static int[][] elimination = new int[8][8];

    public static void main(String[] args) {
        calculateEliminationNumbers();
        int queensPlaced = 0;

        while (queensPlaced < 8) {
            int minElim = Integer.MAX_VALUE;
            int bestRow = -1;
            int bestCol = -1;

            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (board[r][c] == 0 && elimination[r][c] < minElim) {
                        minElim = elimination[r][c];
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }

            if (bestRow == -1) {
                break;
            }

            placeQueen(bestRow, bestCol);
            queensPlaced++;
        }

        if (queensPlaced == 8) {
            System.out.println("Successfully placed 8 queens!");
        } else {
            System.out.println("Only placed " + queensPlaced + " queens.");
        }

        displayBoard();
    }

    public static void calculateEliminationNumbers() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                int count = 0;
                for (int rr = 0; rr < 8; rr++) {
                    for (int cc = 0; cc < 8; cc++) {
                        if (rr == r || cc == c || Math.abs(rr - r) == Math.abs(cc - c)) {
                            count++;
                        }
                    }
                }
                elimination[r][c] = count;
            }
        }
    }

    public static void placeQueen(int row, int col) {
        board[row][col] = 1;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (r == row || c == col || Math.abs(r - row) == Math.abs(c - col)) {
                    elimination[r][c] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public static void displayBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
