import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static void main() {
        SearchAlgorithms searchAlgorithms=new SearchAlgorithms();
        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "T-Shirt", "Clothing"),
                new Product(108, "Novel", "Books"),
                new Product(103, "Blender", "Kitchen"),
                new Product(110, "Headphones", "Electronics")
        };

        System.out.println("Linear search for id 103:");
        System.out.println("  " + searchAlgorithms.linearSearch(products, 103));
        System.out.println("Linear search for id 999:");
        System.out.println("  " + searchAlgorithms.linearSearch(products, 999));

        // Binary search needs sorted data first
        Product[] sorted = products.clone();
        Arrays.sort(sorted,(p1,p2)->Integer.compare(p1.getProductId(), p2.getProductId()));
        System.out.println("\nSorted-by-id array: " + Arrays.toString(sorted));

        System.out.println("\nBinary search for id 108:");
        System.out.println("  " + searchAlgorithms.binarySearch(sorted, 108));
        System.out.println("Binary search for id 104:");
        System.out.println("  " + searchAlgorithms.binarySearch(sorted, 104));
    }
}
/*
 * EXERCISE 2: E-commerce Platform Search Function
 * Implements LINEAR search and BINARY search.
 *
 * Linear search  : O(n)        - checks items one by one
 * Binary search  : O(log n)    - needs the data SORTED
 */