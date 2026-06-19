import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Book[] books = {
                new Book(1, "The Alchemist", "Paulo Coelho"),
                new Book(2, "Clean Code", "Robert Martin"),
                new Book(3, "Atomic Habits", "James Clear"),
                new Book(4, "Wings of Fire", "A.P.J. Abdul Kalam"),
                new Book(5, "Sapiens", "Yuval Noah Harari")
        };

        System.out.println(LibrarySearch.linearSearch(books,"Sapiens"));
        Book[] sortedBooks = books.clone();
        LibrarySearch.sortByTitle(sortedBooks);
        System.out.println(Arrays.toString(sortedBooks)+"\n");
        System.out.println(LibrarySearch.binarySearch(sortedBooks, "Atomic Habits"));
    }
}
/*
 * EXERCISE 6: Library Management System - search books by title.
 * Implements LINEAR search and BINARY search (titles sorted A-Z).
 *
 * For text keys we compare with String.compareToIgnoreCase(...).
 * Linear : O(n)
 * Binary : O(log n)  but the list must be sorted by title first.
 */