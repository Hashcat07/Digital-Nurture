package Upskilling.java;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int target = new Random().nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;

        do {
            System.out.print("Guess a number between 1 and 100: ");
            guess = sc.nextInt();

            if      (guess < target) System.out.println("Too low!");
            else if (guess > target) System.out.println("Too high!");
            else                     System.out.println("Correct! The number was " + target);

        } while (guess != target);

        sc.close();
    }
}