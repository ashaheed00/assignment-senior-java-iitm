import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem4 {

    /**
     * Finds longest winning streak from a given array of ROI values
     *
     * @param roiValues array of given ROI values
     * @return the longest winning streak.
     * Return an empty list when the input is null or empty.
     */
    public static List<Integer> findLongestWinningStreak(int[] roiValues) {
        if (roiValues == null || roiValues.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> winningStreak = new ArrayList<>();
        List<Integer> currentStreak = new ArrayList<>();

        for (int roiValue : roiValues) {
            if (roiValue >= 0) {
                currentStreak.add(roiValue);
            } else {
                if (currentStreak.size() > winningStreak.size()) {
                    winningStreak.clear();
                    winningStreak.addAll(currentStreak);
                }
                currentStreak.clear();
            }
        }

        if (currentStreak.size() > winningStreak.size()) {
            winningStreak.clear();
            winningStreak.addAll(currentStreak);
        }

        return winningStreak;
    }

    /**
     * Finds shortest losing streak from a given array of ROI values
     *
     * @param roiValues array of given ROI values
     * @return the shortest losing streak.
     * Return an empty list when the input is null or empty.
     */
    public static List<Integer> findShortestLosingStreak(int[] roiValues) {
        List<Integer> currentStreak = new ArrayList<>();
        List<Integer> losingStreak = new ArrayList<>();
        int shortestLength = roiValues.length;

        for (int roiValue : roiValues) {
            if (roiValue < 0) {
                currentStreak.add(roiValue);
            } else {
                if (!currentStreak.isEmpty() && currentStreak.size() < shortestLength) {
                    losingStreak.clear();
                    losingStreak.addAll(currentStreak);
                    shortestLength = currentStreak.size();
                }
                currentStreak.clear();
            }
        }

        if (!currentStreak.isEmpty() && currentStreak.size() < shortestLength) {
            losingStreak.clear();
            losingStreak.addAll(currentStreak);
        }

        // When all the elements are losing i.e. negative
        if (currentStreak.size() == roiValues.length) {
            losingStreak.clear();
            losingStreak.addAll(currentStreak);
        }

        return losingStreak;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of years: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        int[] roiValues = new int[n];
        System.out.println("Enter the ROI values for each year:");
        for (int i = 0; i < n; i++) {
            roiValues[i] = scanner.nextInt();
        }

        List<Integer> winningStreak = findLongestWinningStreak(roiValues);
        List<Integer> losingStreak = findShortestLosingStreak(roiValues);

        System.out.println("Longest winning streak: " + winningStreak);
        System.out.println("Shortest losing streak: " + losingStreak);
    }
}
