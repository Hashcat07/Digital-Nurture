import java.util.Arrays;

public class Main {
  static void main() {

        SortingAlgorithms sortingAlgorithms=new SortingAlgorithms();
        Order[] forBubble = {
                new Order(1, "Asha", 2500.0),
                new Order(2, "Ravi", 999.0),
                new Order(3, "Meena", 7800.0),
                new Order(4, "John", 450.0),
                new Order(5, "Priya", 3200.0)
        };
        Order[] forQuick = forBubble.clone();

        System.out.println("Before sorting : " + Arrays.toString(forBubble));

        sortingAlgorithms.bubbleSort(forBubble);
        System.out.println("Bubble sorted  : " + Arrays.toString(forBubble));

        sortingAlgorithms.quickSort(forQuick, 0, forQuick.length - 1);
        System.out.println("Quick sorted   : " + Arrays.toString(forQuick));
    }
}

/*
 * EXERCISE 3: Sorting Customer Orders by totalPrice
 * Implements BUBBLE SORT and QUICK SORT.
 *
 * Bubble Sort : O(n^2) always-ish (simple, slow)
 * Quick Sort  : O(n log n) average, O(n^2) worst case (fast in practice)
 */
