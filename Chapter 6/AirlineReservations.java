import java.util.Scanner;

public class AirlineReservations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[10];
        int firstClassCount = 0;
        int economyCount = 0;

        while (true) {
            System.out.println("Please type 1 for First Class");
            System.out.println("Please type 2 for Economy");
            System.out.println("Please type 0 to exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                if (firstClassCount < 5) {
                    for (int i = 0; i < 5; i++) {
                        if (!seats[i]) {
                            seats[i] = true;
                            firstClassCount++;
                            System.out.println("Boarding Pass: Seat " + (i + 1) + " - First Class");
                            break;
                        }
                    }
                } else {
                    System.out.print("First Class is full. Would you like Economy? (1 for Yes, 0 for No): ");
                    int response = input.nextInt();
                    if (response == 1) {
                        assignEconomy(seats, input, economyCount);
                        economyCount++;
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else if (choice == 2) {
                if (economyCount < 5) {
                    for (int i = 5; i < 10; i++) {
                        if (!seats[i]) {
                            seats[i] = true;
                            economyCount++;
                            System.out.println("Boarding Pass: Seat " + (i + 1) + " - Economy");
                            break;
                        }
                    }
                } else {
                    System.out.print("Economy is full. Would you like First Class? (1 for Yes, 0 for No): ");
                    int response = input.nextInt();
                    if (response == 1) {
                        assignFirstClass(seats, input, firstClassCount);
                        firstClassCount++;
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            }

            if (firstClassCount == 5 && economyCount == 5) {
                System.out.println("Plane is full. Next flight leaves in 3 hours.");
                break;
            }
        }
    }

    public static void assignFirstClass(boolean[] seats, Scanner input, int firstClassCount) {
        for (int i = 0; i < 5; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Boarding Pass: Seat " + (i + 1) + " - First Class");
                return;
            }
        }
    }

    public static void assignEconomy(boolean[] seats, Scanner input, int economyCount) {
        for (int i = 5; i < 10; i++) {
            if (!seats[i]) {
                seats[i] = true;
                System.out.println("Boarding Pass: Seat " + (i + 1) + " - Economy");
                return;
            }
        }
    }
}
