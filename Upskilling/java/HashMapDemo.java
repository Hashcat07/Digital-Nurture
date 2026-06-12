package Upskilling.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> students = new HashMap<>();

        System.out.print("How many entries to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            students.put(id, name);
        }

        System.out.print("Enter ID to look up: ");
        int key = sc.nextInt();
        System.out.println("Name: " + students.getOrDefault(key, "Not found"));

        sc.close();
    }
}