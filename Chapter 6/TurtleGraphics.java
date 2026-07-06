import java.util.Scanner;

public class TurtleGraphics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] floor = new int[20][20];
        boolean penDown = false;
        int currentRow = 0;
        int currentCol = 0;
        int direction = 0;

        System.out.println("Turtle Graphics Commands:");
        System.out.println("1 - Pen up");
        System.out.println("2 - Pen down");
        System.out.println("3 - Turn right");
        System.out.println("4 - Turn left");
        System.out.println("5,n - Move forward n spaces");
        System.out.println("6 - Display the array");
        System.out.println("9 - End of data");

        while (true) {
            System.out.print("Enter command: ");
            String command = input.nextLine();

            if (command.equals("9")) {
                break;
            } else if (command.equals("1")) {
                penDown = false;
            } else if (command.equals("2")) {
                penDown = true;
            } else if (command.equals("3")) {
                direction = (direction + 1) % 4;
            } else if (command.equals("4")) {
                direction = (direction + 3) % 4;
            } else if (command.startsWith("5,")) {
                int steps = Integer.parseInt(command.substring(2));
                for (int s = 0; s < steps; s++) {
                    int nextRow = currentRow;
                    int nextCol = currentCol;

                    if (direction == 0) nextCol++;
                    else if (direction == 1) nextRow++;
                    else if (direction == 2) nextCol--;
                    else if (direction == 3) nextRow--;

                    if (nextRow >= 0 && nextRow < 20 && nextCol >= 0 && nextCol < 20) {
                        currentRow = nextRow;
                        currentCol = nextCol;
                        if (penDown) {
                            floor[currentRow][currentCol] = 1;
                        }
                    }
                }
            } else if (command.equals("6")) {
                for (int r = 0; r < 20; r++) {
                    for (int c = 0; c < 20; c++) {
                        if (floor[r][c] == 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }

        System.out.println("Turtle position: (" + currentRow + ", " + currentCol + ")");
        if (penDown) {
            System.out.println("Pen is down.");
        } else {
            System.out.println("Pen is up.");
        }
    }
}
