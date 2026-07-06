public class CommandLineArguments {
    public static void main(String[] args) {
        int arraySize = 10;
        if (args.length > 0) {
            arraySize = Integer.parseInt(args[0]);
        }

        int[] array = new int[arraySize];
        System.out.println("Array size: " + arraySize);
        System.out.println("Array initialized with " + array.length + " elements.");
    }
}
