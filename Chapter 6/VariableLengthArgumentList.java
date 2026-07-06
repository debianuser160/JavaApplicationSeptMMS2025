public class VariableLengthArgumentList {
    public static int product(int... numbers) {
        int result = 1;
        for (int num : numbers) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Product of 2, 3: " + product(2, 3));
        System.out.println("Product of 4, 5, 6: " + product(4, 5, 6));
        System.out.println("Product of 7, 8, 9, 10: " + product(7, 8, 9, 10));
        System.out.println("Product of 2: " + product(2));
        System.out.println("Product of nothing: " + product());
    }
}
