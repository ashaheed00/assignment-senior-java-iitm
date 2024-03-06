import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem1 {

    /**
     * @param orderList order list in the form of a list
     *                  of dish IDs
     * @return a list of dish IDs in the order in which the restaurant will prepare them.
     * dishes with the most orders before others with a lesser number of orders.
     * If two or more dishes have the same number of orders, then the dish with smaller ID value
     * will be prepared first.
     */
    public static List<Integer> dishPrepareOrder(List<Integer> orderList) {
        // when the list is null or empty, simply return the list before doing any processing
        if (orderList == null || orderList.isEmpty()) {
            return orderList;
        }

        Map<Integer, Long> dishFrequency = orderList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        orderList.sort((id1, id2) -> {
            int freqCompare = dishFrequency.get(id2).compareTo(dishFrequency.get(id1));
            if (freqCompare == 0) {
                return id1.compareTo(id2);
            }
            return freqCompare;
        });

        return orderList;
    }

    public static void main(String[] args) {
        List<Integer> orderList = Arrays.asList(1001, 1003, 1003, 1001, 1005, 1005, 1005, 1008, 1009);
        List<Integer> preparedOrder = dishPrepareOrder(orderList);
        System.out.println("Order of dishes to be prepared: " + preparedOrder);
    }
}
