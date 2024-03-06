import java.util.*;

public class Problem3 {

    /**
     * Finds all the possible pairs from given array which sum up to the target value
     *
     * @param array  given array of numbers with more than 2 elements
     * @param target the target value
     * @return list of pairs. returns empty list when array is having less than 2 numbers.
     */
    public static List<List<Integer>> findPairs(int[] array, int target) {
        // returning an empty list when array is not having at least 2 numbers
        if (array == null || array.length < 2) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (map.containsKey(complement)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(array[map.get(complement)]);
                pair.add(array[i]);
                result.add(pair);
            }
            map.put(array[i], i);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        if (size <= 1) {
            System.out.println("Invalid input. Array size should be greater than 1.");
            return;
        }

        int[] array = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        List<List<Integer>> result = findPairs(array, target);

        if (result.isEmpty()) {
            System.out.println("No distinct elements found that sum up to the target.");
        } else {
            System.out.println("Distinct element pairs that sum up to the target:");
            for (List<Integer> pair : result) {
                System.out.println(pair.get(0) + " + " + pair.get(1) + " = " + target);
            }
        }
    }
}
