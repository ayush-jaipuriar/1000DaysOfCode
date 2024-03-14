package JavaTheory;

public class SwitchArrowLabels {
    public static String getSeason(int month) {
        return switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            // Similar concise logic for Summer and Fall
            default -> "Invalid Month";
        };
    }

    public static void main(String[] args) {
        System.out.println(getSeason(4)); // Output: Spring
    }

}
