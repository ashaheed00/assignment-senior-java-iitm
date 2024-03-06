import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

    /**
     * This method takes a list of strings and prints out two sorted lists.
     * First sorted list: strings sorted in ascending order w.r.t to the first
     * character only. All the strings with the same initial character should be in the same order as in
     * the original list.
     * Second sorted list: Applies same rule as first sorted list but
     * when two or more strings starting with the same character,
     * then sort those in descending order w.r.t the number formed by the remaining characters.
     *
     * @param strings takes a list of unique strings as an argument, where each string is a
     *                combination of a letter from a - z and a number from 0 to 99 , the initial character in string being
     *                the letter. For example a23, d5, z0, q99 are some strings in this format
     */
    public static void sortAlphaNumericStrings(List<String> strings) {
        Comparator<String> l1Comparator = (s1, s2) -> Character.compare(s1.charAt(0), s2.charAt(0));
        Comparator<String> l2Comparator = (s1, s2) -> {
            int compare = Character.compare(s1.charAt(0), s2.charAt(0));
            if (compare == 0) {
                compare = Integer.parseInt(s2.substring(1)) - Integer.parseInt(s1.substring(1));
            }
            return compare;
        };

        List<String> l1 = strings.stream().sorted(l1Comparator).collect(Collectors.toList());
        System.out.print("L1 : ");
        System.out.println(String.join(", ", l1));

        List<String> l2 = strings.stream().sorted(l2Comparator).collect(Collectors.toList());
        System.out.print("L2 : ");
        System.out.println(String.join(", ", l2));
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("d34", "g54", "d12", "b87", "g1", "c65", "g40", "g5", "d77");
        sortAlphaNumericStrings(strings);
    }
}
