import java.security.SecureRandom;

public class EightQueensBruteForce {
    static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        boolean found = false;
        long attempts = 0;

        while (!found) {
            attempts++;
            int[][] board = new int[8][8];
            int queens = 0;

            for (int q = 0; q < 8; q++) {
                boolean placed = false;
                for (int tries = 0; tries < 100; tries++) {
                    int r = random.nextInt(8);
                    int c = random.nextInt(8);
                    if (isSafe(board, r, c)) {
                        board[r][c] = 1;
                        queens++;
                        placed = true;
                        break;
                    }
                }
                if (!placed) break;
            }

            if (queens == 8) {
                found = true;
                System.out.println("Found solution after " + attempts + " attempts:");
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
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < 8; i++) {
            if (board[row][i] == 1) return false;
            if (board[i][col] == 1) return false;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - row) == Math.abs(j - col) && board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
