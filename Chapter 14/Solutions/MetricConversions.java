import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetricConversions {

    private static final Map<String, double[]> UNITS = new HashMap<>();

    private static void addUnit(String name, double factorToBase, int category) {
        UNITS.put(name.toLowerCase(), new double[]{factorToBase, category});
    }

    private static final Pattern QUESTION_PATTERN =
            Pattern.compile("(?i)how\\s+many\\s+([a-z]+)\\s+are in\\s+"
                    + "([0-9]+(?:\\.[0-9]+)?)\\s+([a-z]+)\\s*\\??");

    public static void main(String[] args) {
        loadUnits();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ask a conversion question, e.g.:");
        System.out.println("  How many inches are in 2 meters?");
        System.out.println("  How many liters are in 10 quarts?");
        System.out.println("Press Enter on an empty line to quit.");

        while (true) {
            System.out.print("\nQuestion: ");
            String question = scanner.nextLine().trim();
            if (question.isEmpty()) {
                break;
            }

            Matcher matcher = QUESTION_PATTERN.matcher(question);
            if (!matcher.matches()) {
                System.out.println("I did not understand the question. Try: "
                        + "\"How many inches are in 2 meters?\"");
                continue;
            }

            answer(matcher.group(1), Double.parseDouble(matcher.group(2)), matcher.group(3));
        }
    }

    private static void loadUnits() {
        addUnit("meter", 1.0, 0);
        addUnit("meters", 1.0, 0);
        addUnit("centimeter", 0.01, 0);
        addUnit("centimeters", 0.01, 0);
        addUnit("millimeter", 0.001, 0);
        addUnit("millimeters", 0.001, 0);
        addUnit("kilometer", 1000.0, 0);
        addUnit("kilometers", 1000.0, 0);
        addUnit("inch", 0.0254, 0);
        addUnit("inches", 0.0254, 0);
        addUnit("foot", 0.3048, 0);
        addUnit("feet", 0.3048, 0);
        addUnit("yard", 0.9144, 0);
        addUnit("yards", 0.9144, 0);
        addUnit("mile", 1609.344, 0);
        addUnit("miles", 1609.344, 0);

        addUnit("gram", 1.0, 1);
        addUnit("grams", 1.0, 1);
        addUnit("milligram", 0.001, 1);
        addUnit("milligrams", 0.001, 1);
        addUnit("kilogram", 1000.0, 1);
        addUnit("kilograms", 1000.0, 1);
        addUnit("pound", 453.59237, 1);
        addUnit("pounds", 453.59237, 1);
        addUnit("ounce", 28.349523125, 1);
        addUnit("ounces", 28.349523125, 1);

        addUnit("liter", 1.0, 2);
        addUnit("liters", 1.0, 2);
        addUnit("milliliter", 0.001, 2);
        addUnit("milliliters", 0.001, 2);
        addUnit("quart", 0.946352946, 2);
        addUnit("quarts", 0.946352946, 2);
        addUnit("gallon", 3.785411784, 2);
        addUnit("gallons", 3.785411784, 2);
        addUnit("pint", 0.473176473, 2);
        addUnit("pints", 0.473176473, 2);
        addUnit("cup", 0.24, 2);
        addUnit("cups", 0.24, 2);
    }

    private static void answer(String targetName, double value, String sourceName) {
        double[] source = UNITS.get(sourceName.toLowerCase());
        double[] target = UNITS.get(targetName.toLowerCase());

        if (source == null) {
            System.out.printf("\"%s\" is not a unit I recognize.%n", sourceName);
            return;
        }
        if (target == null) {
            System.out.printf("\"%s\" is not a unit I recognize.%n", targetName);
            return;
        }
        if (source[1] != target[1]) {
            System.out.printf("\"%s\" and \"%s\" measure different quantities;"
                    + " that conversion is not meaningful.%n", sourceName, targetName);
            return;
        }

        double result = value * source[0] / target[0];
        System.out.printf("%s %s = %s %s%n",
                trim(value), sourceName, trim(result), targetName);
    }

    private static String trim(double value) {
        return String.format("%.6f", value).replaceAll("0+$", "").replaceAll("\\.$", "");
    }
}
