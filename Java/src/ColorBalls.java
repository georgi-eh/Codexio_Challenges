import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;;

public class ColorBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> balls = new HashMap<String, Integer>();

        // Read input and store it in map
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] parts = line.split(": ");
            String color = parts[0];
            int count = Integer.parseInt(parts[1]);
            balls.put(color, count);
            line = scanner.nextLine();
        }

        String minColor = "";
        int minCount = Integer.MAX_VALUE;

        // Find the smallest color group
        for (Map.Entry<String, Integer> entry : balls.entrySet()) {
            if (entry.getValue() < minCount) {
                minCount = entry.getValue();
                minColor = entry.getKey();
            }
        }

        // Take all balls except for the smallest color group
        int minSum = 0;
        for (Map.Entry<String, Integer> entry : balls.entrySet()) {
            if (!entry.getKey().equals(minColor)) {
                minSum += entry.getValue();
            }
        }

        System.out.println("Minimum number of balls: " + minSum);
    }
}
