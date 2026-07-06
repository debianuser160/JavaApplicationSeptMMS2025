import java.util.Scanner;

public class Polling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] topics = {
            "Climate Change",
            "Healthcare",
            "Education Funding",
            "Economic Inequality",
            "Digital Privacy"
        };
        int[][] responses = new int[5][10];
        int[] totals = new int[5];

        System.out.println("Rate each issue from 1 (least important) to 10 (most important).");
        System.out.println("Enter -1 to quit.\n");

        while (true) {
            for (int i = 0; i < topics.length; i++) {
                System.out.print(topics[i] + ": ");
                int rating = input.nextInt();
                if (rating == -1) {
                    printResults(topics, responses, totals);
                    return;
                }
                if (rating >= 1 && rating <= 10) {
                    responses[i][rating - 1]++;
                    totals[i] += rating;
                } else {
                    System.out.println("Please enter 1-10.");
                    i--;
                }
            }
            System.out.println();
        }
    }

    public static void printResults(String[] topics, int[][] responses, int[] totals) {
        System.out.printf("\n%-20s", "Topic");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.printf("  %6s\n", "Average");

        int maxTotal = 0, minTotal = Integer.MAX_VALUE;
        String maxTopic = "", minTopic = "";
        int totalRatings = 0;
        int ratingCount = 0;

        for (int i = 0; i < topics.length; i++) {
            System.out.printf("%-20s", topics[i]);
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", responses[i][j]);
            }
            double avg = (double) totals[i] / sumResponses(responses[i]);
            System.out.printf("  %6.2f\n", avg);

            if (totals[i] > maxTotal) {
                maxTotal = totals[i];
                maxTopic = topics[i];
            }
            if (totals[i] < minTotal) {
                minTotal = totals[i];
                minTopic = topics[i];
            }
        }

        System.out.println("\nHighest point total: " + maxTopic + " (" + maxTotal + " points)");
        System.out.println("Lowest point total: " + minTopic + " (" + minTotal + " points)");
    }

    public static int sumResponses(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return sum;
    }
}
