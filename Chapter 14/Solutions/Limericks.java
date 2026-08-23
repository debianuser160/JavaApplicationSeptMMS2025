import java.util.Random;

public class Limericks {

    public static void main(String[] args) {
        String[][] rhymeSetsA = {
            {"Peru", "canoe", "shoe"},
            {"Baltimore", "oar", "door"},
            {"Madrid", "lid", "squid"},
            {"France", "pants", "ants"}
        };
        String[][] rhymeSetsB = {
            {"hat", "cat"},
            {"spoon", "moon"},
            {"book", "crook"}
        };
        String[] professions = {"dancer", "baker", "sailor", "teacher", "plumber"};
        Random random = new Random();

        for (int count = 1; count <= 3; count++) {
            String[] a = rhymeSetsA[random.nextInt(rhymeSetsA.length)];
            String[] b = rhymeSetsB[random.nextInt(rhymeSetsB.length)];
            String profession = professions[random.nextInt(professions.length)];

            System.out.printf("Limerick %d:%n", count);
            System.out.printf("There once was a %s from %s,%n", profession, a[0]);
            System.out.printf("who traveled the world with a %s.%n", a[1]);
            System.out.printf("He bumped into a %s,%n", b[0]);
            System.out.printf("then tripped over a %s,%n", b[1]);
            System.out.printf("and now they tour the globe: the %s and the %s.%n%n",
                    profession, a[2]);
        }
    }
}
