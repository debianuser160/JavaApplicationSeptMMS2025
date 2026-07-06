public class SieveOfEratosthenes {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[1000];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        System.out.println("Prime numbers between 2 and 999:");
        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("\nTotal primes found: " + count);
    }
}
