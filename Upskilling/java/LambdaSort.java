package Upskilling.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(Arrays.asList(
            "New York", "Chicago", "Los Angeles", "Houston", "Phoenix"
        ));

        Collections.sort(cities, (a, b) -> a.compareTo(b));

        System.out.println("Sorted cities: " + cities);
    }
}