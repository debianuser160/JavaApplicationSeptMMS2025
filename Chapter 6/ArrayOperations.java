public class ArrayOperations {
    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }
        System.out.println("counts array initialized to zero.");

        int[] bonus = new int[15];
        for (int i = 0; i < bonus.length; i++) {
            bonus[i]++;
        }
        System.out.println("bonus array incremented by one.");

        int[] bestScores = {95, 87, 92, 78, 88};
        System.out.println("\nbestScores values:");
        for (int i = 0; i < bestScores.length; i++) {
            System.out.println(bestScores[i]);
        }
    }
}
