import java.security.SecureRandom;

public class KnightsTourBruteForce {
    static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int[] tourLengths = new int[65];
        int totalTours = 1000;

        for (int t = 0; t < totalTours; t++) {
            int[][] board = new int[8][8];
            int currentRow = random.nextInt(8);
            int currentCol = random.nextInt(8);
            int moveNumber = 1;
            board[currentRow][currentCol] = moveNumber;

            while (moveNumber < 64) {
                int[] validMoves = new int[8];
                int validCount = 0;

                for (int move = 0; move < 8; move++) {
                    int nextRow = currentRow + vertical[move];
                    int nextCol = currentCol + horizontal[move];

                    if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
                        if (board[nextRow][nextCol] == 0) {
                            validMoves[validCount++] = move;
                        }
                    }
                }

                if (validCount == 0) {
                    break;
                }

                int chosenMove = validMoves[random.nextInt(validCount)];
                currentRow += vertical[chosenMove];
                currentCol += horizontal[chosenMove];
                board[currentRow][currentCol] = ++moveNumber;
            }

            tourLengths[moveNumber]++;
        }

        System.out.println("Tour Length\tTours");
        for (int i = 1; i <= 64; i++) {
            if (tourLengths[i] > 0) {
                System.out.println(i + "\t\t" + tourLengths[i]);
            }
        }
    }
}
